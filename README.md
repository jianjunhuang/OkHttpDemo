# OkHttpDemo
OkHttp demo include OkHttp utils library
## 依赖
```
compile 'com.library.jianjunhuang.okhttputils:okhttputils:0.0.2'
```
## 初始化
```
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .build();
        OkHttpUtils.initUtils(okHttpClient);
```
## 代码
```
private void getAsy(String url) {
        OkHttpUtils.getInstance().getAsy()
                .baseURL(url)
                .build()
                .execute(new ResultCallback() {
                    @Override
                    public void onError(Call call, IOException e) {
                        Toast.makeText(SampleActivity.this, "err", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Response response) {
                        Toast.makeText(SampleActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void postAsy(String url) {
        OkHttpUtils.getInstance().postAsy()
                .baseURL(url)
                .params("size", "10")
                .build()
                .execute(new ResultCallback() {
                    @Override
                    public void onError(Call call, IOException e) {
                        Toast.makeText(SampleActivity.this, "err", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Response response) {
                        Toast.makeText(SampleActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
```
