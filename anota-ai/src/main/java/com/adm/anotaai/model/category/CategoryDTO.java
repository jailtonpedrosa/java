package com.adm.anotaai.model.category;

import jakarta.persistence.Column;

public record CategoryDTO(String title, String description, String ownerId) {
}
