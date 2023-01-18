package br.com.cod3r.composite.folders.model;

import java.util.List;

public class Folder implements FileSystemItem {
    private final String name;
    private final List<FileSystemItem> childrens;

    public Folder(String name, List<FileSystemItem> childrens) {
        this.name = name;
        this.childrens = childrens;
    }

    @Override
    public void print(String structure) {
        System.out.println(structure + name);
        for (FileSystemItem child: childrens) {
            child.print(structure + "| ");
        }
    }
}
