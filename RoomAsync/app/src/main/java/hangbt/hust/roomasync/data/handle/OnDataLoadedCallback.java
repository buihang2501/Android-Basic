package hangbt.hust.roomasync.data.handle;

public interface OnDataLoadedCallback<Data> {
    void onSuccess(Data data);
    void onFailure(Exception exception);
}
