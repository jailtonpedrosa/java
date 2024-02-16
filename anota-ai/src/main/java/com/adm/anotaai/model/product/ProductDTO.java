package com.adm.anotaai.model.product;

import com.adm.anotaai.model.category.Category;
import jakarta.persistence.Column;

import java.util.UUID;

public record ProductDTO(String title, String description, String ownerId, Double price, UUID categoryID) {
}
