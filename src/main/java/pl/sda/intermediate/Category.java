package pl.sda.intermediate;

import lombok.Builder;

@Builder
public class Category {

    private Integer id;
    private String name;
    private Integer parentId;
    private Integer depth;

}
