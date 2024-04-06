package com.example.myfirstproject.firstproject.TOs;

    import com.example.myfirstproject.firstproject.entity.Player;
    import com.example.myfirstproject.firstproject.entity.Squad;

    import java.util.List;
    import java.util.stream.Collectors;

public class SquadResponse {
        private List<PlayerResponse> players;

        public SquadResponse(List<PlayerResponse> players) {
            this.players = players.stream().map(PlayerResponse::new).collect(Collectors.toList());
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
