package idea.analyzesystem.hover.pinnedsection;

/**
 * Created by idea on 2017/1/20.
 */
public interface OnPinnedSectionListener<T> {

    void onPinnedSectionItem(T result);

    void onPinnedSectionNext(T result);
}
