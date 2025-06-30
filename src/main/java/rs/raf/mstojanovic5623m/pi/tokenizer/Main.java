package rs.raf.mstojanovic5623m.pi.tokenizer;

import rs.raf.mstojanovic5623m.pi.tokenizer.folder.Folder;
import rs.raf.mstojanovic5623m.pi.tokenizer.result.ResultServer;
import rs.raf.mstojanovic5623m.pi.tokenizer.result.ResultUtils;

public class Main {
    public static void main(String[] args) {
        Folder folder = new Folder(args[0]);
        ResultServer resultServer = ResultUtils.accept(ResultUtils.canAccept(folder));
        resultServer.save();
    }
}
