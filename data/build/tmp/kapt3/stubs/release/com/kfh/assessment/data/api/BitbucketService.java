package com.kfh.assessment.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\"\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u000f\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/kfh/assessment/data/api/BitbucketService;", "", "getMe", "Lcom/kfh/assessment/data/api/UserDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRepositories", "Lcom/kfh/assessment/data/api/RepoPageDto;", "workspace", "", "pageLen", "", "role", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRepositoryDetails", "Lcom/kfh/assessment/data/api/RepoDto;", "repoSlug", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"})
public abstract interface BitbucketService {
    
    @retrofit2.http.GET(value = "2.0/repositories/{workspace}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRepositories(@retrofit2.http.Path(value = "workspace")
    @org.jetbrains.annotations.NotNull()
    java.lang.String workspace, @retrofit2.http.Query(value = "pagelen")
    int pageLen, @retrofit2.http.Query(value = "role")
    @org.jetbrains.annotations.NotNull()
    java.lang.String role, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kfh.assessment.data.api.RepoPageDto> $completion);
    
    @retrofit2.http.GET(value = "2.0/repositories/{workspace}/{repo_slug}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRepositoryDetails(@retrofit2.http.Path(value = "workspace")
    @org.jetbrains.annotations.NotNull()
    java.lang.String workspace, @retrofit2.http.Path(value = "repo_slug")
    @org.jetbrains.annotations.NotNull()
    java.lang.String repoSlug, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kfh.assessment.data.api.RepoDto> $completion);
    
    @retrofit2.http.GET(value = "2.0/user")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMe(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kfh.assessment.data.api.UserDto> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}