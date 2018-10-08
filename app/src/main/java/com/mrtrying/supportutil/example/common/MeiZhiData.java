package com.mrtrying.supportutil.example.common;

import android.annotation.TargetApi;
import android.os.Build;

import java.io.Serializable;
import java.util.Objects;

/**
 * Description :
 * PackageName : com.mrtrying.supportutil.example.common
 * Created by tanzeyu on 2018/9/30 17:58.
 * e_mail : ztanzeyu@gmail.com
 */
public class MeiZhiData implements Serializable,Cloneable {
    public String image;
    public String who;

    @Override
    public MeiZhiData clone() throws CloneNotSupportedException {
        MeiZhiData data = null;
        try{
            data = (MeiZhiData) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return data;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeiZhiData that = (MeiZhiData) o;
        return Objects.equals(image, that.image) &&
                Objects.equals(who, that.who);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(image, who);
    }
}
