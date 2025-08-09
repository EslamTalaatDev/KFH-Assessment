package com.kfh.assessment.data.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserEntity> __insertionAdapterOfUserEntity;

  private final SharedSQLiteStatement __preparedStmtOfClear;

  public UserDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserEntity = new EntityInsertionAdapter<UserEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `user_me` (`uuid`,`username`,`displayName`,`accountId`,`nickname`,`accountStatus`,`createdOn`,`location`,`has2FA`,`htmlUrl`,`avatarUrl`,`reposUrl`,`snippetsUrl`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserEntity entity) {
        if (entity.getUuid() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getUuid());
        }
        if (entity.getUsername() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUsername());
        }
        if (entity.getDisplayName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDisplayName());
        }
        if (entity.getAccountId() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getAccountId());
        }
        if (entity.getNickname() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getNickname());
        }
        if (entity.getAccountStatus() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getAccountStatus());
        }
        if (entity.getCreatedOn() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getCreatedOn());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getLocation());
        }
        final Integer _tmp = entity.getHas2FA() == null ? null : (entity.getHas2FA() ? 1 : 0);
        if (_tmp == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, _tmp);
        }
        if (entity.getHtmlUrl() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getHtmlUrl());
        }
        if (entity.getAvatarUrl() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getAvatarUrl());
        }
        if (entity.getReposUrl() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getReposUrl());
        }
        if (entity.getSnippetsUrl() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getSnippetsUrl());
        }
      }
    };
    this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM user_me";
        return _query;
      }
    };
  }

  @Override
  public Object upsert(final UserEntity user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserEntity.insert(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object clear(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClear.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfClear.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object get(final Continuation<? super UserEntity> $completion) {
    final String _sql = "SELECT * FROM user_me LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserEntity>() {
      @Override
      @Nullable
      public UserEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "displayName");
          final int _cursorIndexOfAccountId = CursorUtil.getColumnIndexOrThrow(_cursor, "accountId");
          final int _cursorIndexOfNickname = CursorUtil.getColumnIndexOrThrow(_cursor, "nickname");
          final int _cursorIndexOfAccountStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "accountStatus");
          final int _cursorIndexOfCreatedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "createdOn");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfHas2FA = CursorUtil.getColumnIndexOrThrow(_cursor, "has2FA");
          final int _cursorIndexOfHtmlUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "htmlUrl");
          final int _cursorIndexOfAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "avatarUrl");
          final int _cursorIndexOfReposUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "reposUrl");
          final int _cursorIndexOfSnippetsUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "snippetsUrl");
          final UserEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpUuid;
            if (_cursor.isNull(_cursorIndexOfUuid)) {
              _tmpUuid = null;
            } else {
              _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            }
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpDisplayName;
            if (_cursor.isNull(_cursorIndexOfDisplayName)) {
              _tmpDisplayName = null;
            } else {
              _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
            }
            final String _tmpAccountId;
            if (_cursor.isNull(_cursorIndexOfAccountId)) {
              _tmpAccountId = null;
            } else {
              _tmpAccountId = _cursor.getString(_cursorIndexOfAccountId);
            }
            final String _tmpNickname;
            if (_cursor.isNull(_cursorIndexOfNickname)) {
              _tmpNickname = null;
            } else {
              _tmpNickname = _cursor.getString(_cursorIndexOfNickname);
            }
            final String _tmpAccountStatus;
            if (_cursor.isNull(_cursorIndexOfAccountStatus)) {
              _tmpAccountStatus = null;
            } else {
              _tmpAccountStatus = _cursor.getString(_cursorIndexOfAccountStatus);
            }
            final String _tmpCreatedOn;
            if (_cursor.isNull(_cursorIndexOfCreatedOn)) {
              _tmpCreatedOn = null;
            } else {
              _tmpCreatedOn = _cursor.getString(_cursorIndexOfCreatedOn);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final Boolean _tmpHas2FA;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfHas2FA)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfHas2FA);
            }
            _tmpHas2FA = _tmp == null ? null : _tmp != 0;
            final String _tmpHtmlUrl;
            if (_cursor.isNull(_cursorIndexOfHtmlUrl)) {
              _tmpHtmlUrl = null;
            } else {
              _tmpHtmlUrl = _cursor.getString(_cursorIndexOfHtmlUrl);
            }
            final String _tmpAvatarUrl;
            if (_cursor.isNull(_cursorIndexOfAvatarUrl)) {
              _tmpAvatarUrl = null;
            } else {
              _tmpAvatarUrl = _cursor.getString(_cursorIndexOfAvatarUrl);
            }
            final String _tmpReposUrl;
            if (_cursor.isNull(_cursorIndexOfReposUrl)) {
              _tmpReposUrl = null;
            } else {
              _tmpReposUrl = _cursor.getString(_cursorIndexOfReposUrl);
            }
            final String _tmpSnippetsUrl;
            if (_cursor.isNull(_cursorIndexOfSnippetsUrl)) {
              _tmpSnippetsUrl = null;
            } else {
              _tmpSnippetsUrl = _cursor.getString(_cursorIndexOfSnippetsUrl);
            }
            _result = new UserEntity(_tmpUuid,_tmpUsername,_tmpDisplayName,_tmpAccountId,_tmpNickname,_tmpAccountStatus,_tmpCreatedOn,_tmpLocation,_tmpHas2FA,_tmpHtmlUrl,_tmpAvatarUrl,_tmpReposUrl,_tmpSnippetsUrl);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
