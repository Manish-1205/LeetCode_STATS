package com.LeetCodeAPI.LeetCodeAPI.service;


import com.LeetCodeAPI.LeetCodeAPI.dto.LeetCodeDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

@Service
public class LeetCodeService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final String url = "https://leetcode.com/graphql";

    public LeetCodeDTO getProfile(String username) {

        String query = """
                query getUserProfile($username: String!) {
                    matchedUser(username: $username) {
                        username
                        profile {
                            ranking
                        }
                        submitStats {
                            acSubmissionNum {
                                difficulty
                                count
                            }
                        }
                    }
                }
                """;

        Map<String, Object> body = Map.of(
                "query", query,
                "variables", Map.of("username", username)
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<JsonNode> response =
                restTemplate.exchange(url, HttpMethod.POST, request, JsonNode.class);

        JsonNode data = response.getBody();
        JsonNode user = data.get("data").get("matchedUser");

        LeetCodeDTO dto = new LeetCodeDTO();

        dto.setUsername(user.get("username").asText());
        dto.setRanking(user.get("profile").get("ranking").asInt());

        JsonNode submissions = user.get("submitStats").get("acSubmissionNum");

        for (JsonNode submission : submissions) {

            String difficulty = submission.get("difficulty").asText();
            int count = submission.get("count").asInt();

            switch (difficulty) {
                case "All" -> dto.setTotalSolved(count);
                case "Easy" -> dto.setEasySolved(count);
                case "Medium" -> dto.setMediumSolved(count);
                case "Hard" -> dto.setHardSolved(count);
            }
        }

        return dto;
    }
}