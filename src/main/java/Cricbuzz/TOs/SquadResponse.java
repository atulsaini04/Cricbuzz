package Cricbuzz.TOs;
 import Cricbuzz.entity.Squad;
 import java.util.List;
    import java.util.stream.Collectors;

public class SquadResponse {
        private List<PlayerResponse> players;

        public SquadResponse(List<PlayerResponse> players) {
            this.players = players.stream().map(PlayerResponse::new).collect(Collectors.toList());
        }

    public SquadResponse() {
    }

    public SquadResponse(Squad squad) {
    }



    public List<PlayerResponse> getPlayers() {
            return players;
        }

        public void setPlayers(List<PlayerResponse> players) {
            this.players = players;
        }
    }
