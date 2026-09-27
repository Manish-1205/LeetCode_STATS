package com.LeetCodeAPI.LeetCodeAPI.service;

import com.LeetCodeAPI.LeetCodeAPI.dto.LeetCodeDTO;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;


@Service
public class TauntService {

    private final ChatClient chatClient;

    public TauntService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String generateTaunt(LeetCodeDTO stats) {

        String prompt = """
        Generate exactly ONE short, funny, sarcastic DSA taunt based on the LeetCode stats below.

        Rules:
        - Return ONLY the taunt.
        - Do NOT provide multiple options.
        - Do NOT use labels like "Option 1", "Option 2", etc.
        - Do NOT use Markdown.
        - Do NOT use explanations.
        - Maximum 25 words.
        - Keep it developer-friendly and playful.
        - Mention a specific weakness or interesting statistic when possible.
        - Use at most one emoji.

        LeetCode Stats:
        Username: %s
        Total Solved: %d
        Easy: %d
        Medium: %d
        Hard: %d
        Ranking: %d
        """.formatted(
                stats.getUsername(),
                stats.getTotalSolved(),
                stats.getEasySolved(),
                stats.getMediumSolved(),
                stats.getHardSolved(),
                stats.getRanking()
        );

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }


}