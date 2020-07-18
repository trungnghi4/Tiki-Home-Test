package com.ntn.testhometiki;

import org.junit.Assert;
import org.junit.Test;

import com.ntn.testhometiki.utils.FormatKeywork;

public class KeyWordTest {
    @Test
    public void isKeyWordCorrect(){
        Assert.assertEquals("xiaomi", FormatKeywork.splitKeyword("xiaomi"));
        Assert.assertEquals("bitis\nhunter", FormatKeywork.splitKeyword("bitis hunter"));
        Assert.assertEquals("nguyễn\nnhật ánh", FormatKeywork.splitKeyword("nguyễn nhật ánh"));
        Assert.assertEquals("anh chính là\nthanh xuân của em", FormatKeywork.splitKeyword("anh chính là thanh xuân của em"));
        Assert.assertEquals("tai nghe\nbluetooth", FormatKeywork.splitKeyword("tai nghe bluetooth"));
        Assert.assertEquals("đắc nhân\ntâm", FormatKeywork.splitKeyword("đắc nhân tâm"));
        Assert.assertEquals("túi đéo\nchéo", FormatKeywork.splitKeyword("túi đéo chéo"));
        Assert.assertEquals("sạc dự\nphòng", FormatKeywork.splitKeyword("sạc dự phòng"));
        Assert.assertEquals("bánh trung\nthu kinh đô", FormatKeywork.splitKeyword("bánh trung thu kinh đô"));
    }
}
