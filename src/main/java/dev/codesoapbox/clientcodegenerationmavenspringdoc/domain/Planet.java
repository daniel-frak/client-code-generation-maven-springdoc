package dev.codesoapbox.clientcodegenerationmavenspringdoc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "A standard planet")
@Data
public class Planet {

    @Schema(description = "Uniquely identifies the planet")
    private final Long id;

    @Schema(description = "A human-readable name")
    private final String name;

    @Schema(description = "Whether or not life can survive on the surface")
    @JsonProperty("isHabitable")
    private final boolean isHabitable;
}
