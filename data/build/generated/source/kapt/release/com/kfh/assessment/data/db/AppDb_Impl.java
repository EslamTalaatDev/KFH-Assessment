package com.kfh.assessment.data.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDb_Impl extends AppDb {
  private volatile RepoDao _repoDao;

  private volatile RepoDetailDao _repoDetailDao;

  private volatile UserDao _userDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `repos` (`uuid` TEXT NOT NULL, `name` TEXT NOT NULL, `fullName` TEXT NOT NULL, `slug` TEXT NOT NULL, `description` TEXT, PRIMARY KEY(`uuid`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `repo_details` (`slug` TEXT NOT NULL, `uuid` TEXT NOT NULL, `name` TEXT NOT NULL, `fullName` TEXT NOT NULL, `description` TEXT, `isPrivate` INTEGER, `scm` TEXT, `language` TEXT, `size` INTEGER, `createdOn` TEXT, `updatedOn` TEXT, `mainBranch` TEXT, `ownerDisplayName` TEXT, `htmlUrl` TEXT, PRIMARY KEY(`slug`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `user_me` (`uuid` TEXT NOT NULL, `username` TEXT, `displayName` TEXT, `accountId` TEXT, `nickname` TEXT, `accountStatus` TEXT, `createdOn` TEXT, `location` TEXT, `has2FA` INTEGER, `htmlUrl` TEXT, `avatarUrl` TEXT, `reposUrl` TEXT, `snippetsUrl` TEXT, PRIMARY KEY(`uuid`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8b394120e922617e0da98d1d3efab85e')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `repos`");
        db.execSQL("DROP TABLE IF EXISTS `repo_details`");
        db.execSQL("DROP TABLE IF EXISTS `user_me`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsRepos = new HashMap<String, TableInfo.Column>(5);
        _columnsRepos.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRepos.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRepos.put("fullName", new TableInfo.Column("fullName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRepos.put("slug", new TableInfo.Column("slug", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRepos.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRepos = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRepos = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRepos = new TableInfo("repos", _columnsRepos, _foreignKeysRepos, _indicesRepos);
        final TableInfo _existingRepos = TableInfo.read(db, "repos");
        if (!_infoRepos.equals(_existingRepos)) {
          return new RoomOpenHelper.ValidationResult(false, "repos(com.kfh.assessment.data.db.RepoEntity).\n"
                  + " Expected:\n" + _infoRepos + "\n"
                  + " Found:\n" + _existingRepos);
        }
        final HashMap<String, TableInfo.Column> _columnsRepoDetails = new HashMap<String, TableInfo.Column>(14);
        _columnsRepoDetails.put("slug", new TableInfo.Column("slug", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRepoDetails.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRepoDetails.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRepoDetails.put("fullName", new TableInfo.Column("fullName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRepoDetails.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRepoDetails.put("isPrivate", new TableInfo.Column("isPrivate", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRepoDetails.put("scm", new TableInfo.Column("scm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRepoDetails.put("language", new TableInfo.Column("language", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRepoDetails.put("size", new TableInfo.Column("size", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRepoDetails.put("createdOn", new TableInfo.Column("createdOn", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRepoDetails.put("updatedOn", new TableInfo.Column("updatedOn", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRepoDetails.put("mainBranch", new TableInfo.Column("mainBranch", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRepoDetails.put("ownerDisplayName", new TableInfo.Column("ownerDisplayName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRepoDetails.put("htmlUrl", new TableInfo.Column("htmlUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRepoDetails = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRepoDetails = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRepoDetails = new TableInfo("repo_details", _columnsRepoDetails, _foreignKeysRepoDetails, _indicesRepoDetails);
        final TableInfo _existingRepoDetails = TableInfo.read(db, "repo_details");
        if (!_infoRepoDetails.equals(_existingRepoDetails)) {
          return new RoomOpenHelper.ValidationResult(false, "repo_details(com.kfh.assessment.data.db.RepoDetailEntity).\n"
                  + " Expected:\n" + _infoRepoDetails + "\n"
                  + " Found:\n" + _existingRepoDetails);
        }
        final HashMap<String, TableInfo.Column> _columnsUserMe = new HashMap<String, TableInfo.Column>(13);
        _columnsUserMe.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserMe.put("username", new TableInfo.Column("username", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserMe.put("displayName", new TableInfo.Column("displayName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserMe.put("accountId", new TableInfo.Column("accountId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserMe.put("nickname", new TableInfo.Column("nickname", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserMe.put("accountStatus", new TableInfo.Column("accountStatus", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserMe.put("createdOn", new TableInfo.Column("createdOn", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserMe.put("location", new TableInfo.Column("location", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserMe.put("has2FA", new TableInfo.Column("has2FA", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserMe.put("htmlUrl", new TableInfo.Column("htmlUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserMe.put("avatarUrl", new TableInfo.Column("avatarUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserMe.put("reposUrl", new TableInfo.Column("reposUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserMe.put("snippetsUrl", new TableInfo.Column("snippetsUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserMe = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserMe = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserMe = new TableInfo("user_me", _columnsUserMe, _foreignKeysUserMe, _indicesUserMe);
        final TableInfo _existingUserMe = TableInfo.read(db, "user_me");
        if (!_infoUserMe.equals(_existingUserMe)) {
          return new RoomOpenHelper.ValidationResult(false, "user_me(com.kfh.assessment.data.db.UserEntity).\n"
                  + " Expected:\n" + _infoUserMe + "\n"
                  + " Found:\n" + _existingUserMe);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "8b394120e922617e0da98d1d3efab85e", "998ce57dfb4b148983840d9bf53467bc");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "repos","repo_details","user_me");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `repos`");
      _db.execSQL("DELETE FROM `repo_details`");
      _db.execSQL("DELETE FROM `user_me`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(RepoDao.class, RepoDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(RepoDetailDao.class, RepoDetailDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public RepoDao repoDao() {
    if (_repoDao != null) {
      return _repoDao;
    } else {
      synchronized(this) {
        if(_repoDao == null) {
          _repoDao = new RepoDao_Impl(this);
        }
        return _repoDao;
      }
    }
  }

  @Override
  public RepoDetailDao repoDetailDao() {
    if (_repoDetailDao != null) {
      return _repoDetailDao;
    } else {
      synchronized(this) {
        if(_repoDetailDao == null) {
          _repoDetailDao = new RepoDetailDao_Impl(this);
        }
        return _repoDetailDao;
      }
    }
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }
}
