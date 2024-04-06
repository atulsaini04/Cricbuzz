package Cricbuzz.TOs;
public class AddPlayerResponse {
    private String message;
    private Long playerId;

    public AddPlayerResponse() {
    }

    public AddPlayerResponse(String message, Long playerId) {
        this.message = message;
        this.playerId = playerId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }
// Constructors, getters, and setters
}
