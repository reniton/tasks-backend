package br.ce.wcaquino.taskbackend.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DateUtilsTest {

    @Test
    public void deveRetornarTrueParaDatasFuturas(){
        LocalDate date = LocalDate.of(2030,03,01);
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
    }
    @Test
    public void deveRetornarFalseParaDatasPassadas(){
        LocalDate date = LocalDate.of(2010,03,01);
        Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
    }
    @Test
    public void deveRetornarTrueParaDatasPresente(){
        LocalDate date = LocalDate.now();
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
    }
}
