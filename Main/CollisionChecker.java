package main;

public class CollisionChecker {
    GamePanel gp; 
    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }
    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x; // Left x-coordinate of the entity's solid area
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width; // Right x-coordinate of the entity's solid area
        int entityTopWorldY = entity.worldY + entity.solidArea.y; // Top y-coordinate of the entity's solid area
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height; // Bottom y-coordinate of the entity's solid area
        int entityLeftCol = entityLeftWorldX / gp.TileSize; // Column of the left side of the entity's solid area
        int entityRightCol = entityRightWorldX / gp.TileSize; // Column of the right side of the entity's solid area
        int entityTopRow = entityTopWorldY / gp.TileSize; // Row of the top side of the entity's solid area
        int entityBottomRow = entityBottomWorldY / gp.TileSize; // Row of the bottom side of the entity's solid area
        int tileNum1, tileNum2; // Tile numbers for collision checking
        switch(entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.TileSize; // Update top row for upward movement
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow]; // Tile number for the left side of the entity's solid area
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow]; // Tile number for the right side of the entity's solid area
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true; // Collision detected, set collision flag to true
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.TileSize; // Update bottom row for downward movement
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow]; // Tile number for the left side of the entity's solid area
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow]; // Tile number for the right side of the entity's solid area
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true; // Collision detected, set collision flag to true
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.TileSize; // Update left column for leftward movement
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow]; // Tile number for the left side of the entity's solid area
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow]; // Tile number for the left side of the entity's solid area
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true; // Collision detected, set collision flag to true
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.TileSize; // Update right column for rightward movement
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow]; // Tile number for the right side of the entity's solid area
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow]; // Tile number for the right side of the entity's solid area
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true; // Collision detected, set collision flag to true
                }
                break;
        }
    }
        
}
