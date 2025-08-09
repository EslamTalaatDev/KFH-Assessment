package com.kfh.assessment.data.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/kfh/assessment/data/db/AppDb;", "Landroidx/room/RoomDatabase;", "()V", "repoDao", "Lcom/kfh/assessment/data/db/RepoDao;", "repoDetailDao", "Lcom/kfh/assessment/data/db/RepoDetailDao;", "userDao", "Lcom/kfh/assessment/data/db/UserDao;", "data_release"})
@androidx.room.Database(entities = {com.kfh.assessment.data.db.RepoEntity.class, com.kfh.assessment.data.db.RepoDetailEntity.class, com.kfh.assessment.data.db.UserEntity.class}, version = 1, exportSchema = false)
public abstract class AppDb extends androidx.room.RoomDatabase {
    
    public AppDb() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kfh.assessment.data.db.RepoDao repoDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kfh.assessment.data.db.RepoDetailDao repoDetailDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kfh.assessment.data.db.UserDao userDao();
}