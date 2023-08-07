package org.rehab.control.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Setter
@Getter
public class EmailDto {
    @JsonProperty("toUser")
    private String toUser;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("message")
    private String message;
}