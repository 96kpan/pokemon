
//Test cases for the Item Class

package test;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.GameController;
import model.*;
import pokemons.*;
import view.BattleView;
import item.*;

public class itemTest {

	@Test
	public void pokeballTest() {
		Item pokeball = new Pokeball(50);
		assertEquals(pokeball.getItemName(), "Pokeball");
		assertEquals(pokeball.getNumOfItems(), 50);
		assertEquals(pokeball.getPrice(), 100);
		assertEquals(pokeball.toString(), "Pokeball");
	}

	@Test
	public void setterTest() {
		Item item = new Pokeball(10);
		item.setItemName("Poke");
		assertEquals(item.getItemName(), "Poke");
		item.setNumOfItems(100);
		assertEquals(item.getNumOfItems(), 100);
		item.setPrice(5);
		assertEquals(item.getPrice(), 5);

	}

	@Test
	public void useItemTest() {
		Pokeball pb = new Pokeball(1);
		assertEquals(pb.getItemName(), "Pokeball");
		assertEquals(pb.getNumOfItems(), 1);
		pb.setPrice(500);
		assertEquals(pb.getPrice(), 500);
		Charmander ch = new Charmander(1, 1, "Charmander", "Fire", false, 35, null);
		assertEquals(pb.capturePokemon(ch), "Captured: Charmander");
		Charmander ch2 = new Charmander(1, 1, "Charmander", "Fire", false, 65, null);
		assertEquals(pb.capturePokemon(ch2), "Pokemon not Captured...");
	}

	@Test
	public void otherItemTest() {
		HealthPot hp = new HealthPot("HealthPot", 1);
		assertEquals(hp.getItemName(), "HealthPot");
		assertEquals(hp.getNumOfItems(), 1);
		assertEquals(hp.toString(), "HealthPot");
		Bait b = new Bait("Bait", 2);
		assertEquals(b.getItemName(), "Bait");
		assertEquals(b.getNumOfItems(), 2);
		assertEquals(b.toString(), "Bait");

	}

	@Test
	public void modelTest() {
		Bag b = new Bag();
		b.addItem(new Pokeball(1));
		b.addItem(new Pokeball(1));
		b.toString();
		b.addItem(new Pokeball(1));
		b.addItem(new Pokeball(1));
		b.addItem(new Pokeball(1));
		b.useItem(new Pokeball(1));
		b.removeItem("Pokeball");
		b.removeItem("Pokeball");
		// b.numItems();
		b.removeItem("Pokeball");
		b.removeItem("Pokeball");
		b.removeItem("Pokeball");
		b.removeItem("Pokeball");
		b.removeItem("Pokeball");
		b.removeItem("Pokeball");
		b.removeItem("Pokeball");
		b.getCountOfItems("Pokeball");
		b.getCountOfItems("Pokebal");
		b.toString();
		b.getNumOfPokeballs();
		// b.numItems();

	}

	@Test
	public void TbattleTest() {
		//

		TrainerBattle b = new TrainerBattle(new PokemonGame(new MapOne()));
		((TrainerBattle) b).attack();
		((TrainerBattle) b).battlePokemonToString();
		((TrainerBattle) b).chosenHP();
		((TrainerBattle) b).chosenName();
		((TrainerBattle) b).getBattlePokemon();
		((TrainerBattle) b).getCaughtPokemon();
		((TrainerBattle) b).getHP();
		((TrainerBattle) b).getMyTrainer();
		((TrainerBattle) b).myTrainerToString();
		((TrainerBattle) b).battleOver();
		((TrainerBattle) b).getName();
		((TrainerBattle) b).getRandomPokemon();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).runAway();

	}

	@Test
	public void TbattleTest1() {
		//

		TrainerBattle b = new TrainerBattle(new PokemonGame(new MapOne()));
		((TrainerBattle) b).attack();
		((TrainerBattle) b).battlePokemonToString();
		((TrainerBattle) b).chosenHP();
		((TrainerBattle) b).chosenName();
		((TrainerBattle) b).getBattlePokemon();
		((TrainerBattle) b).getCaughtPokemon();
		((TrainerBattle) b).getHP();
		((TrainerBattle) b).getMyTrainer();
		((TrainerBattle) b).myTrainerToString();
		((TrainerBattle) b).battleOver();
		((TrainerBattle) b).getName();
		((TrainerBattle) b).getRandomPokemon();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).runAway();

	}

	@Test
	public void TbattleTest2() {
		//

		TrainerBattle b = new TrainerBattle(new PokemonGame(new MapOne()));
		((TrainerBattle) b).attack();
		((TrainerBattle) b).battlePokemonToString();
		((TrainerBattle) b).chosenHP();
		((TrainerBattle) b).chosenName();
		((TrainerBattle) b).getBattlePokemon();
		((TrainerBattle) b).getCaughtPokemon();
		((TrainerBattle) b).getHP();
		((TrainerBattle) b).getMyTrainer();
		((TrainerBattle) b).myTrainerToString();
		((TrainerBattle) b).battleOver();
		((TrainerBattle) b).getName();
		((TrainerBattle) b).getRandomPokemon();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).runAway();

	}

	@Test
	public void TbattleTest3() {
		//

		TrainerBattle b = new TrainerBattle(new PokemonGame(new MapOne()));
		((TrainerBattle) b).attack();
		((TrainerBattle) b).battlePokemonToString();
		((TrainerBattle) b).chosenHP();
		((TrainerBattle) b).chosenName();
		((TrainerBattle) b).getBattlePokemon();
		((TrainerBattle) b).getCaughtPokemon();
		((TrainerBattle) b).getHP();
		((TrainerBattle) b).getMyTrainer();
		((TrainerBattle) b).myTrainerToString();
		((TrainerBattle) b).battleOver();
		((TrainerBattle) b).getName();
		((TrainerBattle) b).getRandomPokemon();
		((TrainerBattle) b).getRandomPokemon();
		((TrainerBattle) b).getRandomPokemon();
		((TrainerBattle) b).getRandomPokemon();

		((TrainerBattle) b).getRandomPokemon();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).runAway();

	}

	@Test
	public void TbattleTest5() {
		//

		TrainerBattle b = new TrainerBattle(new PokemonGame(new MapOne()));
		((TrainerBattle) b).attack();
		((TrainerBattle) b).battlePokemonToString();
		((TrainerBattle) b).chosenHP();
		((TrainerBattle) b).chosenName();
		((TrainerBattle) b).getBattlePokemon();
		((TrainerBattle) b).getCaughtPokemon();
		((TrainerBattle) b).getHP();
		((TrainerBattle) b).getMyTrainer();
		((TrainerBattle) b).myTrainerToString();
		((TrainerBattle) b).battleOver();
		((TrainerBattle) b).getName();
		((TrainerBattle) b).getRandomPokemon();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).runAway();

	}

	@Test
	public void TbattleTest6() {
		//

		TrainerBattle b = new TrainerBattle(new PokemonGame(new MapOne()));
		((TrainerBattle) b).attack();
		((TrainerBattle) b).battlePokemonToString();
		((TrainerBattle) b).chosenHP();
		((TrainerBattle) b).chosenName();
		((TrainerBattle) b).getBattlePokemon();
		((TrainerBattle) b).getCaughtPokemon();
		((TrainerBattle) b).getHP();
		((TrainerBattle) b).getMyTrainer();
		((TrainerBattle) b).myTrainerToString();
		((TrainerBattle) b).battleOver();
		((TrainerBattle) b).getName();
		((TrainerBattle) b).getRandomPokemon();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).runAway();

	}

	@Test
	public void TbattleTest7() {
		//

		TrainerBattle b = new TrainerBattle(new PokemonGame(new MapOne()));
		((TrainerBattle) b).attack();
		((TrainerBattle) b).battlePokemonToString();
		((TrainerBattle) b).chosenHP();
		((TrainerBattle) b).chosenName();
		((TrainerBattle) b).getBattlePokemon();
		((TrainerBattle) b).getCaughtPokemon();
		((TrainerBattle) b).getHP();
		((TrainerBattle) b).getMyTrainer();
		((TrainerBattle) b).myTrainerToString();
		((TrainerBattle) b).battleOver();
		((TrainerBattle) b).getName();
		((TrainerBattle) b).getRandomPokemon();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).runAway();

	}

	@Test
	public void TbattleTest8() {
		//

		TrainerBattle b = new TrainerBattle(new PokemonGame(new MapOne()));
		((TrainerBattle) b).attack();
		((TrainerBattle) b).battlePokemonToString();
		((TrainerBattle) b).chosenHP();
		((TrainerBattle) b).chosenName();
		((TrainerBattle) b).getBattlePokemon();
		((TrainerBattle) b).getCaughtPokemon();
		((TrainerBattle) b).getHP();
		((TrainerBattle) b).getMyTrainer();
		((TrainerBattle) b).myTrainerToString();
		((TrainerBattle) b).battleOver();
		((TrainerBattle) b).getName();
		((TrainerBattle) b).getRandomPokemon();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).runAway();

	}

	@Test
	public void TbattleTest9() {
		//

		TrainerBattle b = new TrainerBattle(new PokemonGame(new MapOne()));
		((TrainerBattle) b).attack();
		((TrainerBattle) b).battlePokemonToString();
		((TrainerBattle) b).chosenHP();
		((TrainerBattle) b).chosenName();
		((TrainerBattle) b).getBattlePokemon();
		((TrainerBattle) b).getCaughtPokemon();
		((TrainerBattle) b).getHP();
		((TrainerBattle) b).getMyTrainer();
		((TrainerBattle) b).myTrainerToString();
		((TrainerBattle) b).battleOver();
		((TrainerBattle) b).getName();
		((TrainerBattle) b).getRandomPokemon();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).runAway();

	}

	@Test
	public void TbattleTest10() {
		//

		TrainerBattle b = new TrainerBattle(new PokemonGame(new MapOne()));
		((TrainerBattle) b).attack();
		((TrainerBattle) b).battlePokemonToString();
		((TrainerBattle) b).chosenHP();
		((TrainerBattle) b).chosenName();
		((TrainerBattle) b).getBattlePokemon();
		((TrainerBattle) b).getCaughtPokemon();
		((TrainerBattle) b).getHP();
		((TrainerBattle) b).getMyTrainer();
		((TrainerBattle) b).myTrainerToString();
		((TrainerBattle) b).battleOver();
		((TrainerBattle) b).getName();
		((TrainerBattle) b).getRandomPokemon();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).runAway();

	}

	@Test
	public void TbattleTest11() {
		//

		TrainerBattle b = new TrainerBattle(new PokemonGame(new MapOne()));
		((TrainerBattle) b).attack();
		((TrainerBattle) b).battlePokemonToString();
		((TrainerBattle) b).chosenHP();
		((TrainerBattle) b).chosenName();
		((TrainerBattle) b).getBattlePokemon();
		((TrainerBattle) b).getCaughtPokemon();
		((TrainerBattle) b).getHP();
		((TrainerBattle) b).getMyTrainer();
		((TrainerBattle) b).myTrainerToString();
		((TrainerBattle) b).battleOver();
		((TrainerBattle) b).getName();
		((TrainerBattle) b).getRandomPokemon();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));

		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));

		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));

		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));

		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).runAway();

	}

	@Test
	public void TbattleTest12() {
		//

		TrainerBattle b = new TrainerBattle(new PokemonGame(new MapOne()));
		((TrainerBattle) b).attack();
		((TrainerBattle) b).battlePokemonToString();
		((TrainerBattle) b).chosenHP();
		((TrainerBattle) b).chosenName();
		((TrainerBattle) b).getBattlePokemon();
		((TrainerBattle) b).getCaughtPokemon();
		((TrainerBattle) b).getHP();
		((TrainerBattle) b).getMyTrainer();
		((TrainerBattle) b).myTrainerToString();
		((TrainerBattle) b).battleOver();
		((TrainerBattle) b).getName();
		((TrainerBattle) b).getRandomPokemon();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));

		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));

		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));

		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));

		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();

		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).runAway();

	}

	@Test
	public void TbattleTest13() {
		//

		TrainerBattle b = new TrainerBattle(new PokemonGame(new MapOne()));
		((TrainerBattle) b).attack();
		((TrainerBattle) b).battlePokemonToString();
		((TrainerBattle) b).chosenHP();
		((TrainerBattle) b).chosenName();
		((TrainerBattle) b).getBattlePokemon();
		((TrainerBattle) b).getCaughtPokemon();
		((TrainerBattle) b).getHP();
		((TrainerBattle) b).getMyTrainer();
		((TrainerBattle) b).myTrainerToString();
		((TrainerBattle) b).battleOver();
		((TrainerBattle) b).getName();
		((TrainerBattle) b).getRandomPokemon();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));

		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));

		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));

		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));

		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).getMyTrainer().getBackpack().addItem(new Bait("Bait", 1));
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();

		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();

		((TrainerBattle) b).battleOver();
		((TrainerBattle) b).runAway();

	}

	@Test
	public void TbattleTest14() {
		//

		TrainerBattle b = new TrainerBattle(new PokemonGame(new MapOne()));
		((TrainerBattle) b).attack();
		((TrainerBattle) b).battlePokemonToString();
		((TrainerBattle) b).chosenHP();
		((TrainerBattle) b).chosenName();
		((TrainerBattle) b).getBattlePokemon();
		((TrainerBattle) b).getCaughtPokemon();
		((TrainerBattle) b).getHP();
		((TrainerBattle) b).getMyTrainer();
		((TrainerBattle) b).myTrainerToString();
		((TrainerBattle) b).battleOver();
		((TrainerBattle) b).getName();
		((TrainerBattle) b).getRandomPokemon();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();

		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwPokeball();

		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwPokeball();

		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwPokeball();

		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwPokeball();

		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).runAway();

	}

	@Test
	public void TbattleTest15() {
		//
		TrainerBattle b = new TrainerBattle(new PokemonGame(new MapOne()));
		((TrainerBattle) b).attack();
		((TrainerBattle) b).battlePokemonToString();
		((TrainerBattle) b).chosenHP();
		((TrainerBattle) b).chosenName();
		((TrainerBattle) b).getBattlePokemon();
		((TrainerBattle) b).getCaughtPokemon();
		((TrainerBattle) b).getHP();
		((TrainerBattle) b).getMyTrainer();
		((TrainerBattle) b).myTrainerToString();
		((TrainerBattle) b).battleOver();
		((TrainerBattle) b).getName();
		((TrainerBattle) b).getRandomPokemon();
		((TrainerBattle) b).throwPokeball();
		((TrainerBattle) b).throwBait();
		((TrainerBattle) b).runAway();

	}

	@Test
	public void testTrainer() {
		Trainer t = new Trainer("Katie");
		t.addSteps(500);
		t.getBackOfTrainer();
		t.getDir();
		t.getImage();
		t.getLocation();
		t.getName();
		t.getPokemons();
		t.getTotalHealthLeft();
		t.setImage(null);

	}

	@Test
	public void testGame() {
		PokemonGame g = new PokemonGame(new MapOne());
		g.isGameOver();
		g.acquireItem();
		g.acquireItem();
		g.acquireItem();
		g.acquireItem();
		g.acquireItem();
		g.acquireItem();
		g.acquireItem();
		g.getMap();
		g.acquireItem();
		g.isGameOver();
		g.launchBattle(1);
		g.isGameOver();
		g.toString();
		g.toStringNoOfSteps();
		g.isGameOver();
		g.isGameOver();
		g.isGameOver();

	}

	@Test
	public void testTile() {
		Tile t = new ItemTile(null, new Pokeball(1));
		PokemonGame g = new PokemonGame(new MapOne());
		t.getHasPokemon();
		t.getHasTrainer();
		t.canMove();
		t.playerIsOnTile(g);
		t.setHasTrainer(false);
		t.setHasTrainer(true);

	}

	@Test
	public void testTile2() {
		Tile t = new TerrainTile(null, "g");
		PokemonGame g = new PokemonGame(new MapOne());
		t.getHasPokemon();
		t.getHasTrainer();
		t.canMove();
		t.playerIsOnTile(g);
		t.setHasTrainer(false);
		t.setHasTrainer(true);

	}

	@Test
	public void testTile3() {
		Tile t = new EmptyTile(null);
		PokemonGame g = new PokemonGame(new MapOne());
		t.getHasPokemon();
		t.getHasTrainer();
		t.canMove();
		t.playerIsOnTile(g);
		t.setHasTrainer(false);
		t.setHasTrainer(true);

	}

	@Test
	public void testTile4() {
		Tile t = new GrassTile(null);
		PokemonGame g = new PokemonGame(new MapOne());
		t.getHasPokemon();
		t.getHasTrainer();
		t.canMove();
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.setHasTrainer(false);
		t.setHasTrainer(true);

	}

	@Test
	public void testTile14() {
		Tile t = new GrassTile(null);
		PokemonGame g = new PokemonGame(new MapOne());
		t.getHasPokemon();
		t.getHasTrainer();
		t.canMove();
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.setHasTrainer(false);
		t.setHasTrainer(true);

	}

	@Test
	public void testTile24() {
		Tile t = new GrassTile(null);
		PokemonGame g = new PokemonGame(new MapOne());
		t.getHasPokemon();
		t.getHasTrainer();
		t.canMove();
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.setHasTrainer(false);
		t.setHasTrainer(true);

	}

	@Test
	public void testTile34() {
		Tile t = new GrassTile(null);
		PokemonGame g = new PokemonGame(new MapOne());
		t.getHasPokemon();
		t.getHasTrainer();
		t.canMove();
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.setHasTrainer(false);
		t.setHasTrainer(true);

	}

	@Test
	public void testTile44() {
		Tile t = new GrassTile(null);
		PokemonGame g = new PokemonGame(new MapOne());
		t.getHasPokemon();
		t.getHasTrainer();
		t.canMove();
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.setHasTrainer(false);
		t.setHasTrainer(true);

	}

	@Test
	public void testTile5() {
		Tile t = new GrassTile(null);
		PokemonGame g = new PokemonGame(new MapOne());
		t.getHasPokemon();
		t.getHasTrainer();
		t.canMove();
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.setHasTrainer(false);
		t.setHasTrainer(true);

	}

	@Test
	public void testTile6() {
		Tile t = new GrassTile(null);
		PokemonGame g = new PokemonGame(new MapOne());
		t.getHasPokemon();
		t.getHasTrainer();
		t.canMove();
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.playerIsOnTile(g);
		t.setHasTrainer(false);
		t.setHasTrainer(true);

	}

	@Test
	public void testTrainer69() {
		Trainer t = new Trainer("Alex please give us an A");
		t.setImage(Direction.North);
		t.setImage(Direction.South);
		t.setImage(Direction.East);
		t.setImage(Direction.West);

	}

	// step count
	@Test
	public void testwinConditions() {
		PokemonGame g = new PokemonGame(new MapOne());

		// Trainer t = new Trainer("Alex please give us an A");

		// g.trainer.addSteps(501);

		g.isGameOver();

	}

	// step count
	@Test
	public void testwinConditions2() {
		PokemonGame g = new PokemonGame(new MapOne());
		BossTile b = new BossTile(null);
		b.playerIsOnTile(g);
		Trainer t = new Trainer("Alex please give us an A");
		g.toggleMap();
		g.toggleMap();
		for(int x = 0; x < 20; x++)
			g.moveTrainer(Direction.North);
	}

	// step count
	@Test
	public void testBag() {
		Bag b = new Bag();
		b.addItem(new Pokeball(1));
		int x = b.numItems();
		b.useItem(new Pokeball(1));
		int y = b.numItems();
		Direction.East.valueOf(Direction.East.toString());
		Direction.North.valueOf(Direction.North.toString());
		Direction.South.valueOf(Direction.South.toString());
		Direction.West.valueOf(Direction.West.toString());
	}
	
	@Test
	public void testBag2() {
		Bag b = new Bag();
		b.addItem(new Pokeball(-31));
	}

	@Test
	public void testAttack2() {
		Battle b = new TrainerBattle(new PokemonGame(new MapOne()));
		BattleView bv = new BattleView(b);
		b.getMyTrainer();
		b.attack();
		b.attack();
		b.attack();
		b.attack();
		b.attack();
		b.attack();
		b.attack();
		b.attack();
		
		b.getRandomPokemon();
		for(int x = 0; x < 10000; x++)
			b.pokemonShouldRun();
		b.throwBait();
		b.runAway();
		b.getMyTrainer();
		b.getCaughtPokemon();
		b.battlePokemonToString();
		b.myTrainerToString();
		b.getName();
		b.getHP();
		b.chosenHP();
		b.chosenName();
	}
	
	@Test
	public void testMovement() {
		PokemonGame pg = new PokemonGame(new MapOne());
		for(int x = 0; x < 1000; x++) {
			pg.moveTrainer(Direction.South);
			pg.moveTrainer(Direction.East);
			pg.moveTrainer(Direction.North);
			pg.moveTrainer(Direction.West);
		}
		
	}
	
}