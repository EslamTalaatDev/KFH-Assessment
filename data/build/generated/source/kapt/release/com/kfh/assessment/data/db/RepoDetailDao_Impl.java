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
import java.lang.Long;
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
public final class RepoDetailDao_Impl implements RepoDetailDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<RepoDetailEntity> __insertionAdapterOfRepoDetailEntity;

  private final SharedSQLiteStatement __preparedStmtOfClear;

  public RepoDetailDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRepoDetailEntity = new EntityInsertionAdapter<RepoDetailEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `repo_details` (`slug`,`uuid`,`name`,`fullName`,`description`,`isPrivate`,`scm`,`language`,`size`,`createdOn`,`updatedOn`,`mainBranch`,`ownerDisplayName`,`htmlUrl`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final RepoDetailEntity entity) {
        if (entity.getSlug() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getSlug());
        }
        if (entity.getUuid() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUuid());
        }
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getName());
        }
        if (entity.getFullName() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getFullName());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDescription());
        }
        final Integer _tmp = entity.isPrivate() == null ? null : (entity.isPrivate() ? 1 : 0);
        if (_tmp == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, _tmp);
        }
        if (entity.getScm() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getScm());
        }
        if (entity.getLanguage() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getLanguage());
        }
        if (entity.getSize() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getSize());
        }
        if (entity.getCreatedOn() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getCreatedOn());
        }
        if (entity.getUpdatedOn() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getUpdatedOn());
        }
        if (entity.getMainBranch() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getMainBranch());
        }
        if (entity.getOwnerDisplayName() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getOwnerDisplayName());
        }
        if (entity.getHtmlUrl() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getHtmlUrl());
        }
      }
    };
    this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM repo_details";
        return _query;
      }
    };
  }

  @Override
  public Object upsert(final RepoDetailEntity entity,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRepoDetailEntity.insert(entity);
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
  public Object get(final String slug, final Continuation<? super RepoDetailEntity> $completion) {
    final String _sql = "SELECT * FROM repo_details WHERE slug = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (slug == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, slug);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<RepoDetailEntity>() {
      @Override
      @Nullable
      public RepoDetailEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "slug");
          final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "fullName");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfIsPrivate = CursorUtil.getColumnIndexOrThrow(_cursor, "isPrivate");
          final int _cursorIndexOfScm = CursorUtil.getColumnIndexOrThrow(_cursor, "scm");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
          final int _cursorIndexOfCreatedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "createdOn");
          final int _cursorIndexOfUpdatedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedOn");
          final int _cursorIndexOfMainBranch = CursorUtil.getColumnIndexOrThrow(_cursor, "mainBranch");
          final int _cursorIndexOfOwnerDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "ownerDisplayName");
          final int _cursorIndexOfHtmlUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "htmlUrl");
          final RepoDetailEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpSlug;
            if (_cursor.isNull(_cursorIndexOfSlug)) {
              _tmpSlug = null;
            } else {
              _tmpSlug = _cursor.getString(_cursorIndexOfSlug);
            }
            final String _tmpUuid;
            if (_cursor.isNull(_cursorIndexOfUuid)) {
              _tmpUuid = null;
            } else {
              _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpFullName;
            if (_cursor.isNull(_cursorIndexOfFullName)) {
              _tmpFullName = null;
            } else {
              _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Boolean _tmpIsPrivate;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfIsPrivate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfIsPrivate);
            }
            _tmpIsPrivate = _tmp == null ? null : _tmp != 0;
            final String _tmpScm;
            if (_cursor.isNull(_cursorIndexOfScm)) {
              _tmpScm = null;
            } else {
              _tmpScm = _cursor.getString(_cursorIndexOfScm);
            }
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final Long _tmpSize;
            if (_cursor.isNull(_cursorIndexOfSize)) {
              _tmpSize = null;
            } else {
              _tmpSize = _cursor.getLong(_cursorIndexOfSize);
            }
            final String _tmpCreatedOn;
            if (_cursor.isNull(_cursorIndexOfCreatedOn)) {
              _tmpCreatedOn = null;
            } else {
              _tmpCreatedOn = _cursor.getString(_cursorIndexOfCreatedOn);
            }
            final String _tmpUpdatedOn;
            if (_cursor.isNull(_cursorIndexOfUpdatedOn)) {
              _tmpUpdatedOn = null;
            } else {
              _tmpUpdatedOn = _cursor.getString(_cursorIndexOfUpdatedOn);
            }
            final String _tmpMainBranch;
            if (_cursor.isNull(_cursorIndexOfMainBranch)) {
              _tmpMainBranch = null;
            } else {
              _tmpMainBranch = _cursor.getString(_cursorIndexOfMainBranch);
            }
            final String _tmpOwnerDisplayName;
            if (_cursor.isNull(_cursorIndexOfOwnerDisplayName)) {
              _tmpOwnerDisplayName = null;
            } else {
              _tmpOwnerDisplayName = _cursor.getString(_cursorIndexOfOwnerDisplayName);
            }
            final String _tmpHtmlUrl;
            if (_cursor.isNull(_cursorIndexOfHtmlUrl)) {
              _tmpHtmlUrl = null;
            } else {
              _tmpHtmlUrl = _cursor.getString(_cursorIndexOfHtmlUrl);
            }
            _result = new RepoDetailEntity(_tmpSlug,_tmpUuid,_tmpName,_tmpFullName,_tmpDescription,_tmpIsPrivate,_tmpScm,_tmpLanguage,_tmpSize,_tmpCreatedOn,_tmpUpdatedOn,_tmpMainBranch,_tmpOwnerDisplayName,_tmpHtmlUrl);
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
