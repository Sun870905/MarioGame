//Elizabeth Sims
//September 22, 2021
//Assignment 3

import java.util.ArrayList;

class Model
{
	ArrayList<Brick> bricks;
	int cameraPos;

	Model()
	{
		bricks = new ArrayList<Brick>();
		cameraPos = 0;
	}

	void load(Json json) {
		cameraPos = (int)json.get("cameraPos").asLong();
		bricks = new ArrayList<>();
		Json bricksList = json.get("bricks");
		for (int i = 0; i<bricksList.size(); i++) {
			Json brick = bricksList.get(i);
			Brick b = new Brick((int)brick.get("x").asLong(), (int)brick.get("y").asLong(),
					(int)brick.get("w").asLong(), (int)brick.get("h").asLong());
			bricks.add(b);
		}
	}

	Json marshal() {
		Json ob = Json.newObject();
		ob.add("cameraPos", cameraPos);
		Json tmpList = Json.newList();
		for (int i = 0; i < bricks.size(); i++)
			tmpList.add(bricks.get(i).marshal());
		ob.add("bricks", tmpList);
		return ob;
	}
}
