package edu.svecw.myshop.loaders;

public class Runner
{
    public static void main(final String[] args) {
        LoadCategories lc = new LoadCategories();
        lc.loadData();
        LoadProducts lp = new LoadProducts();
        lp.loadData();
    }
}