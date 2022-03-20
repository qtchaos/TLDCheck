package com.chaos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TLDCheck {

    public static void main(String[] args) throws IOException {
        String[] TLDs = {"aaa","aarp","abb","abc","able","ac","aco","ad","adac","ads","ae","aeg","aero","af","afl","ag","ai","aig","akdn","al","ally","am","amex","anz","ao","aol","app","aq","ar","arab","army","arpa","art","arte","as","asda","asia","at","au","audi","auto","aw","aws","ax","axa","az","ba","baby","band","bank","bar","bb","bbc","bbt","bbva","bcg","bcn","bd","be","beer","best","bet","bf","bg","bh","bi","bid","bike","bing","bio","biz","bj","blog","blue","bm","bms","bmw","bn","bo","bofa","bom","bond","boo","book","bot","box","br","bs","bt","buy","buzz","bv","bw","by","bz","bzh","ca","cab","cafe","cal","call","cam","camp","car","care","cars","casa","case","cash","cat","cba","cbn","cbre","cbs","cc","cd","ceo","cern","cf","cfa","cfd","cg","ch","chat","ci","citi","city","ck","cl","club","cm","cn","co","com","cool","coop","cpa","cr","crs","cu","cv","cw","cx","cy","cyou","cz","dad","data","date","day","dclk","dds","de","deal","dell","desi","dev","dhl","diet","dish","diy","dj","dk","dm","dnp","do","docs","dog","dot","dtv","dvag","dvr","dz","eat","ec","eco","edu","ee","eg","er","erni","es","esq","et","eu","eus","fage","fail","fan","fans","farm","fast","fi","fiat","fido","film","fire","fish","fit","fj","fk","flir","fly","fm","fo","foo","food","ford","fox","fr","free","frl","ftr","fun","fund","fyi","ga","gal","game","gap","gay","gb","gbiz","gd","gdn","ge","gea","gent","gf","gg","ggee","gh","gi","gift","gl","gle","gm","gmbh","gmo","gmx","gn","gold","golf","goo","goog","gop","got","gov","gp","gq","gr","gs","gt","gu","guge","guru","gw","gy","hair","haus","hbo","hdfc","help","here","hgtv","hiv","hk","hkt","hm","hn","host","hot","how","hr","hsbc","ht","hu","ibm","icbc","ice","icu","id","ie","ieee","ifm","il","im","imdb","immo","in","inc","info","ing","ink","int","io","iq","ir","is","ist","it","itau","itv","java","jcb","je","jeep","jio","jll","jm","jmp","jnj","jo","jobs","jot","joy","jp","jprs","kddi","ke","kfh","kg","kh","ki","kia","kim","kiwi","km","kn","kp","kpmg","kpn","kr","krd","kred","kw","ky","kz","la","land","lat","law","lb","lc","lds","lego","lgbt","li","lidl","life","like","limo","link","live","lk","llc","llp","loan","loft","lol","love","lpl","lr","ls","lt","ltd","ltda","lu","luxe","lv","ly","ma","maif","man","map","mba","mc","md","me","med","meet","meme","men","menu","mg","mh","mil","mini","mint","mit","mk","ml","mlb","mls","mm","mma","mn","mo","mobi","moda","moe","moi","mom","moto","mov","mp","mq","mr","ms","msd","mt","mtn","mtr","mu","mv","mw","mx","my","mz","na","nab","name","navy","nba","nc","ne","nec","net","new","news","next","nf","nfl","ng","ngo","nhk","ni","nico","nike","nl","no","now","np","nr","nra","nrw","ntt","nu","nyc","nz","obi","ollo","om","one","ong","onl","ooo","open","org","ott","ovh","pa","page","pars","pay","pccw","pe","pet","pf","pg","ph","phd","pics","pid","pin","ping","pink","pk","pl","play","plus","pm","pn","pnc","pohl","porn","post","pr","pro","prod","prof","pru","ps","pt","pub","pw","pwc","py","qa","qpon","re","read","red","reit","ren","rent","rest","rich","ril","rio","rip","ro","room","rs","rsvp","ru","ruhr","run","rw","rwe","sa","safe","sale","sap","sarl","sas","save","saxo","sb","sbi","sbs","sc","sca","scb","scot","sd","se","seat","seek","ses","sew","sex","sexy","sfr","sg","sh","shaw","shia","shop","show","si","silk","sina","site","sj","sk","ski","skin","sky","sl","sm","sn","sncf","so","sohu","song","sony","soy","spa","spot","sr","srl","ss","st","star","stc","su","surf","sv","sx","sy","sz","tab","talk","tax","taxi","tc","tci","td","tdk","team","tech","tel","teva","tf","tg","th","thd","tiaa","tips","tj","tjx","tk","tl","tm","tn","to","top","town","toys","tr","trv","tt","tube","tui","tv","tvs","tw","tz","ua","ubs","ug","uk","uno","uol","ups","us","uy","uz","va","vana","vc","ve","vet","vg","vi","vig","vin","vip","visa","viva","vivo","vn","vote","voto","vu","wang","wed","weir","wf","wien","wiki","win","wine","wme","work","wow","ws","wtc","wtf","xbox","xin","xxx","xyz","ye","yoga","you","yt","yun","za","zara","zero","zip","zm","zone","zw"}; // ik this is messy but im too lazy to make it better
        Scanner inputFile = new Scanner(new File("words.txt")).useDelimiter(",");

        List<String> temps = new ArrayList<>();
        while (inputFile.hasNext()) {
            String token = inputFile.next();
            temps.add(token);
        }
        inputFile.close();

        String[] array = temps.toArray(new String[0]);

        System.out.println("Words that end with a TLD: ");
        FileWriter fw = new FileWriter("output.txt");
        String file = "";

        long startTime = System.nanoTime(); // Gets the time before executing array task so that it can be used to calculate completion time.

        int a = 0; // Used for counting the number of matches.
        for (String s : array) {
            if (org.apache.commons.lang3.StringUtils.endsWithAny(s, TLDs)) {
                file = file + s;
                a++;
                System.out.println("Match num: " + a);
            }
        }
        fw.write(file);
        fw.close();

        // Calculates completion time.
        long endTime = System.nanoTime();
        long duration = ((endTime - startTime) / 1000000000);
        System.out.println("Completed in " + duration + "s");
    }
}
