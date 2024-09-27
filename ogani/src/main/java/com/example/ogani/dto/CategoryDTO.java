package com.example.ogani.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO implements Serializable {

    @NotNull(message="Tên danh mục rỗng")
    @NotBlank(message = "Tên danh mục rỗng")
    @Size(min = 5, max = 50, message ="Độ dài danh mục từ 5-50 ký tự")
    private String name;
}
