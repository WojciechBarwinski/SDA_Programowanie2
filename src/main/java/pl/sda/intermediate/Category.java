package pl.sda.intermediate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class Category {

    private Integer id;
    private String name;
    @Setter
    private Integer parentId;
    private Integer depth;

}
