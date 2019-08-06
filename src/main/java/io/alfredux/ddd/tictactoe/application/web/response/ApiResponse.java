package io.alfredux.ddd.tictactoe.application.web.response;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.Map;

@Value
public class ApiResponse {

    private LocalDateTime time;
    private Map<String, Object> data;

    public ApiResponse(Map<String, Object> data) {
        this.time = LocalDateTime.now();
        this.data = data;
    }
}
