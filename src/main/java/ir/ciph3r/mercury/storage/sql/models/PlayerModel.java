package ir.ciph3r.mercury.storage.sql.models;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.sql.SQLException;

@DatabaseTable(tableName = "players")
public class PlayerModel {
	@Getter @Setter
	private static Dao<PlayerModel, String> playerDao;
	@Getter @Setter @DatabaseField(generatedId = true)
	private int id;
	@Getter @Setter @DatabaseField(canBeNull = false, unique = true)
	private String name;
	@Getter @Setter @DatabaseField(canBeNull = false, unique = true)
	private String uuid;
	@Getter @Setter @DatabaseField
	private String nickName;
	@Getter @Setter @DatabaseField(canBeNull = false)
	private int numberOfJoins;
	@Getter @Setter @DatabaseField(canBeNull = false)
	private int numberOfDeaths;
	@Getter @Setter @DatabaseField(canBeNull = false)
	private long firstJoin;

	public PlayerModel() {}

	public PlayerModel(Player player) {
		setName(player.getName());
		setUuid(player.getUniqueId().toString());
	}

	public PlayerModel create() {
		try {
			setNickName(null);
			setNumberOfJoins(0);
			setNumberOfDeaths(0);
			setFirstJoin(System.currentTimeMillis());
			return getPlayerDao().createIfNotExists(this);
		} catch (SQLException e) {
			return null;
		}
	}

	public static PlayerModel queryByUUID(String uuid) {
		try {
			return playerDao.queryForEq("uuid", uuid).get(0);
		} catch (SQLException | IndexOutOfBoundsException e) {
			return null;
		}
	}

	public static PlayerModel queryByName(String name) {
		try {
			return playerDao.queryForEq("name", name).get(0);
		} catch (SQLException | IndexOutOfBoundsException e) {
			return null;
		}
	}

	public void update() {
		try {
			getPlayerDao().update(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setNick(String value) {
		setNickName(value);
		update();
	}

	public void incrementJoins(int value) {
		setNumberOfJoins(getNumberOfJoins() + value);
		update();
	}

	public void incrementDeath(int value) {
		setNumberOfDeaths(getNumberOfDeaths() + value);
		update();
	}
}
