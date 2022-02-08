package ir.ciph3r.mercury.storage.sql;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.storage.sql.models.PlayerModel;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class DataSource {
	private final Mercury mercury;
	private static ConnectionSource connectionSource;

	public DataSource(Mercury mercury) {
		this.mercury = mercury;
	}
	public void SQLite() {
		try {
			createStorageDirectory();
			File file = new File(mercury.getDataFolder() + "/Storage", "data.db");
			file.createNewFile();

			String databaseUrl = "jdbc:sqlite:" + file;
			connectionSource = new JdbcConnectionSource(databaseUrl);

			setupTables();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void createStorageDirectory() {
		File file = new File(mercury.getDataFolder() + "/Storage");
		file.mkdirs();
	}

	public static void setupTables() throws SQLException {
		PlayerModel.setPlayerDao(DaoManager.createDao(connectionSource, PlayerModel.class));
		TableUtils.createTableIfNotExists(connectionSource, PlayerModel.class);
	}
}
