package TStream.model;

import TStream.db.entity.ItemEntity;

public record FavoriteRequestBody(
        ItemEntity favorite
) {}
