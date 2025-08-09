package com.kfh.assessment.data.repo;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ4\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u0014J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u001aH\u0096@\u00a2\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/kfh/assessment/data/repo/BitbucketRepositoryImpl;", "Lcom/kfh/assessment/domain/repo/BitbucketRepository;", "api", "Lcom/kfh/assessment/data/api/BitbucketService;", "db", "Lcom/kfh/assessment/data/db/AppDb;", "(Lcom/kfh/assessment/data/api/BitbucketService;Lcom/kfh/assessment/data/db/AppDb;)V", "getMe", "Lcom/kfh/assessment/domain/model/User;", "forceRefresh", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRepositories", "", "Lcom/kfh/assessment/domain/model/Repo;", "workspace", "", "role", "pageLen", "", "(Ljava/lang/String;Ljava/lang/String;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRepositoryDetails", "Lcom/kfh/assessment/domain/model/RepoDetail;", "repoSlug", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logoutClearAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"})
public final class BitbucketRepositoryImpl implements com.kfh.assessment.domain.repo.BitbucketRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.kfh.assessment.data.api.BitbucketService api = null;
    @org.jetbrains.annotations.NotNull()
    private final com.kfh.assessment.data.db.AppDb db = null;
    
    public BitbucketRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.kfh.assessment.data.api.BitbucketService api, @org.jetbrains.annotations.NotNull()
    com.kfh.assessment.data.db.AppDb db) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getRepositories(@org.jetbrains.annotations.NotNull()
    java.lang.String workspace, @org.jetbrains.annotations.NotNull()
    java.lang.String role, int pageLen, boolean forceRefresh, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.kfh.assessment.domain.model.Repo>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getRepositoryDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String workspace, @org.jetbrains.annotations.NotNull()
    java.lang.String repoSlug, boolean forceRefresh, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kfh.assessment.domain.model.RepoDetail> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getMe(boolean forceRefresh, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kfh.assessment.domain.model.User> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object logoutClearAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}