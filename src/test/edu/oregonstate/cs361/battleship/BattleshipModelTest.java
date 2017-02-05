/**
 * Created by Zaengle on 2/3/2017.
 */

package edu.oregonstate.cs361.battleship;

import com.google.gson.Gson;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spark.Spark;
import spark.utils.IOUtils;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static spark.Spark.awaitInitialization;

public class BattleshipModelTest {

    @Test
    public void ModelTest(){
        BattleshipModel model = new BattleshipModel();

        Ship AC = new Ship("AircraftCarrier", 5, 0, 0, 0, 0);
        Ship BS = new Ship("BattleShip", 4, 0, 0, 0, 0);
        Ship CR = new Ship("Cruiser", 3, 0, 0, 0, 0);
        Ship DR = new Ship("Destroyer", 2, 0, 0, 0, 0);
        Ship SB = new Ship("Submarine", 2, 0, 0, 0, 0);
        assertEquals(AC.get_name(), model.getaircraftCarrier().get_name());
        assertEquals(AC.get_name(), model.getAircraftCarrier().get_name());
        assertEquals(AC.get_name(), model.getAIaircraftCarrier().get_name());
        assertEquals(AC.get_length(), model.getaircraftCarrier().get_length());
        assertEquals(0, model.getaircraftCarrier().get_end().get_y());
        assertEquals(0, model.getaircraftCarrier().get_start().get_x());

        assertEquals(BS.get_name(), model.getBattleship().get_name());
        assertEquals(BS.get_name(), model.getAIbattleship().get_name());

        assertEquals(CR.get_name(), model.getCruiser().get_name());
        assertEquals(CR.get_name(), model.getAIcruiser().get_name());

        assertEquals(DR.get_name(), model.getDestroyer().get_name());
        assertEquals(DR.get_name(), model.getAIdestroyer().get_name());

        assertEquals(SB.get_name(), model.getSubmarine().get_name());
        assertEquals(SB.get_name(), model.getAIsubmarine().get_name());

        model.setAircraftCarrier(AC);
        model.aircraftCarrier(AC);
        model.setDestroyer(DR);
        model.setBattleship(BS);
        model.setSubmarine(SB);
        model.setCruiser(CR);

        model.setAIaircraftCarrier(AC);
        model.setComputer_aircraftCarrier(AC);
        model.setAIdestroyer(DR);
        model.setComputer_destroyer(DR);
        model.setAIbattleship(BS);
        model.setComputer_battleship(BS);
        model.setAIsubmarine(SB);
        model.setComputer_submarine(SB);
        model.setAIcruiser(CR);
        model.setComputer_cruiser(CR);

        assertEquals(AC, model.getComputer_aircraftCarrier());
        assertEquals(BS, model.getComputer_battleship());
        assertEquals(DR, model.getComputer_destroyer());
        assertEquals(SB, model.getComputer_submarine());
        assertEquals(CR, model.getComputer_cruiser());

        ArrayList<Coord> testHits = new ArrayList<Coord>();
        ArrayList<Coord> testMisses = new ArrayList<Coord>();

        assertEquals(model.get_player_hits(), testHits);
        assertEquals(model.get_computer_misses(), testHits);

        assertEquals(model.get_player_misses(), testMisses);
        assertEquals(model.get_computer_misses(), testMisses);

        Coord shot = new Coord(2, 3);
        Coord miss = new Coord(5, 7);

        testHits.add(shot);
        testMisses.add(miss);

        model.add_computer_hit(shot);
        model.add_computer_miss(miss);
        model.add_player_hit(shot);
        model.add_player_miss(miss);

        assertEquals(model.get_player_hits(), testHits);
        assertEquals(model.get_computer_hits(), testHits);

        assertEquals(model.get_player_misses(), testMisses);
        assertEquals(model.get_computer_misses(), testMisses);

        assertEquals(2, shot.get_x());
        assertEquals(3, shot.get_y());

        ArrayList<Coord> newtest = new ArrayList<Coord>();
        Coord new1 = new Coord(9, 7);
        Coord new2 = new Coord(6, 3);
        Coord new3 = new Coord(0, 1);
        newtest.add(new1);
        newtest.add(new2);
        newtest.add(new3);

        model.setComputerHits(newtest);
        model.setComputerMisses(newtest);
        model.setPlayerHits(newtest);
        model.setPlayerMisses(newtest);

        assertEquals(newtest, model.getComputerHits());
        assertEquals(newtest, model.getComputerMisses());
        assertEquals(newtest, model.getPlayerHits());
        assertEquals(newtest, model.getPlayerMisses());

        model.getaircraftCarrier().set_location(2, 3, "horizontal");
        assertEquals(8, model.getaircraftCarrier().get_end().get_y());
        model.getBattleship().set_location(2, 4, "vertical");
        assertEquals(6, model.getBattleship().get_end().get_x());
        model.getSubmarine().set_location(10, 10, "horizontal");
        model.getCruiser().set_location(10,10, "vertical");
        assertEquals(0, model.getCruiser().get_end().get_x());

    }

    @Test
    public void testFireAt2(){

    }

}
