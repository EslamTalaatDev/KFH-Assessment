package com.kfh.assessment.data.net;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u000f"}, d2 = {"Lcom/kfh/assessment/data/net/OkHttpRetrofit;", "", "()V", "authInterceptor", "Lokhttp3/Interceptor;", "store", "Lcom/kfh/assessment/data/store/CredStore;", "moshi", "Lcom/squareup/moshi/Moshi;", "service", "Lcom/kfh/assessment/data/api/BitbucketService;", "serviceWithBasic", "user", "", "pass", "data_debug"})
public final class OkHttpRetrofit {
    @org.jetbrains.annotations.NotNull()
    public static final com.kfh.assessment.data.net.OkHttpRetrofit INSTANCE = null;
    
    private OkHttpRetrofit() {
        super();
    }
    
    private final okhttp3.Interceptor authInterceptor(com.kfh.assessment.data.store.CredStore store) {
        return null;
    }
    
    private final com.squareup.moshi.Moshi moshi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kfh.assessment.data.api.BitbucketService service(@org.jetbrains.annotations.NotNull()
    com.kfh.assessment.data.store.CredStore store) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kfh.assessment.data.api.BitbucketService serviceWithBasic(@org.jetbrains.annotations.NotNull()
    java.lang.String user, @org.jetbrains.annotations.NotNull()
    java.lang.String pass) {
        return null;
    }
}