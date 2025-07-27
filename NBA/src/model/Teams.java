package model;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Teams {

    public ObservableList<Team> currentTeams;
    public ObservableList<Team> teams;

    public Teams() {
        this.currentTeams = FXCollections.<Team>observableArrayList();
        this.teams = FXCollections.observableArrayList(
                new Team("Suns"),
                new Team("Bulls"),
                new Team("Nets"),
                new Team("Bucks"),
                new Team("Pacers"),
                new Team("Thunder"),
                new Team("Lakers"),
                new Team("Nuggets"));

        TeamInit();
        this.currentTeams.addAll(this.teams);
        teams.addListener(new ListChangeListener<Team>() {
            @Override
            public void onChanged(javafx.collections.ListChangeListener.Change<? extends Team> c) {
                currentTeams.clear();
                currentTeams.addAll(teams);
            }
        });
    }

    public ObservableList<Team> currentTeams() {
        return this.currentTeams;
    }

    public void TeamInit() {
        for (Team t : this.teams) {
            switch (t.getName()) {
                case "Suns":
                    t.getCurrentPlayers().add(new Player("Devin Booker", 2500.0, 28, 1));
                    t.getCurrentPlayers().add(new Player("Jalen Green", 2100.0, 23, 3));
                    t.getCurrentPlayers().add(new Player("Royce O'Neale", 1200.0, 32, 00));
                    t.getCurrentPlayers().add(new Player("Dillon Brooks", 1800.0, 29, 9));
                    t.getCurrentPlayers().add(new Player("Mark Williams", 1750.0, 23, 5));
                    for (Player player : t.getCurrentPlayers()) {
                        player.setTeam(t);
                    }
                    break;
                case "Bulls":
                    t.getCurrentPlayers().add(new Player("Josh Giddey", 2100.0, 22, 3));
                    t.getCurrentPlayers().add(new Player("Coby White", 1800.0, 25, 0));
                    t.getCurrentPlayers().add(new Player("Ayo Dosunmu", 1230.0, 25, 11));
                    t.getCurrentPlayers().add(new Player("Matas Buzelis", 1350.0, 20, 14));
                    t.getCurrentPlayers().add(new Player("Nikola Vucevic", 2600.0, 34, 9));
                    for (Player player : t.getCurrentPlayers()) {
                        player.setTeam(t);
                    }
                    break;
                case "Nets":
                    t.getCurrentPlayers().add(new Player("Egor Demin", 900.0, 19, 8));
                    t.getCurrentPlayers().add(new Player("Cam Thomas", 1900.0, 22, 24));
                    t.getCurrentPlayers().add(new Player("Ziaire Williams", 1400.0, 23, 8));
                    t.getCurrentPlayers().add(new Player("Michael Porter Jr.", 2100.0, 27, 7));
                    t.getCurrentPlayers().add(new Player("Nic Claxton", 2000.0, 26, 33));
                    for (Player player : t.getCurrentPlayers()) {
                        player.setTeam(t);
                    }
                    break;
                case "Bucks":
                    t.getCurrentPlayers().add(new Player("Kevin Porter Jr.", 1200.0, 25, 3));
                    t.getCurrentPlayers().add(new Player("Gary Trent Jr.", 1700.0, 25, 5));
                    t.getCurrentPlayers().add(new Player("Kyle Kuzma", 900.0, 29, 18));
                    t.getCurrentPlayers().add(new Player("Giannis Antetokounmpo", 3000.0, 30, 34));
                    t.getCurrentPlayers().add(new Player("Myles Turner", 2100.0, 30, 33));

                    for (Player player : t.getCurrentPlayers()) {
                        player.setTeam(t);
                    }
                    break;

                case "Pacers":
                    t.getCurrentPlayers().add(new Player("Tyrese Haliburton", 2500.0, 25, 0));
                    t.getCurrentPlayers().add(new Player("Andrew Nembhard", 1800.0, 24, 2));
                    t.getCurrentPlayers().add(new Player("Aaron Nesmith", 1700.0, 24, 23));
                    t.getCurrentPlayers().add(new Player("Pascal Siakam", 2550.0, 30, 43));
                    t.getCurrentPlayers().add(new Player("Tony Bradley", 700.0, 29, 33));
                    for (Player player : t.getCurrentPlayers()) {
                        player.setTeam(t);
                    }
                    break;

                
                case "Thunder":
                    t.getCurrentPlayers().add(new Player("Shai Gilgeous-Alexander", 2900.0, 26, 2));
                    t.getCurrentPlayers().add(new Player("Luguentz Dort", 2000.0, 25, 5));
                    t.getCurrentPlayers().add(new Player("Jalen Williams", 2300.0, 23, 9));
                    t.getCurrentPlayers().add(new Player("Chet Holmgren", 2100.0, 22, 7));
                    t.getCurrentPlayers().add(new Player("Isaiah Hartenstein", 1900.0, 26, 55));
                    for (Player player : t.getCurrentPlayers()) {
                        player.setTeam(t);
                    }
                    break;

                case "Lakers":
                    t.getCurrentPlayers().add(new Player("Luka Doncic", 2900.0, 26, 77));
                    t.getCurrentPlayers().add(new Player("Austin Reaves", 2000.0, 26, 15));
                    t.getCurrentPlayers().add(new Player("Rui Hachimura", 1700.0, 27, 8));
                    t.getCurrentPlayers().add(new Player("LeBron James", 2750.0, 39, 6));
                    t.getCurrentPlayers().add(new Player("Deandre Ayton", 1800.0, 26, 31));
                    for (Player player : t.getCurrentPlayers()) {
                        player.setTeam(t);
                    }
                    break;

                case "Nuggets":
                    t.getCurrentPlayers().add(new Player("Jamal Murray", 2400.0, 27, 27));
                    t.getCurrentPlayers().add(new Player("Christian Braun", 1700.0, 25, 1));
                    t.getCurrentPlayers().add(new Player("Cameron Johnson", 1800.0, 28, 23));
                    t.getCurrentPlayers().add(new Player("Aaron Gordon", 1900.0, 29, 50));
                    t.getCurrentPlayers().add(new Player("Nikola Jokic", 2950.0, 30, 15));
                    for (Player player : t.getCurrentPlayers()) {
                        player.setTeam(t);
                    }
                    break;

                


            }
        }
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public boolean hasTeam(String name) {
        for (Team e : teams) {
            if (e.hasName(name) && !name.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public Team getTeam(String name) {
        for (Team p : teams) {
            if (p.hasName(name)) {
                return p;
            }
        }
        return null;
    }

    public void remove(Team p) {
        this.teams.remove(p);
    }

    public void remove(ArrayList<Team> selectedItems) {
        this.teams.removeAll(selectedItems);
    }

    public void addTeams(ArrayList<Team> selectedItems) {
        this.teams.addAll(selectedItems);
    }

    public ObservableList<Player> allPlayersList() {
        ObservableList<Player> viewList;
        viewList = FXCollections.<Player>observableArrayList();

        for (Team t : this.teams) {
            viewList.addAll(t.getCurrentPlayers());
        }
        return viewList;
    }

}
