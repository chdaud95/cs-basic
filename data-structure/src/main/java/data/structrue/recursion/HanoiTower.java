package data.structrue.recursion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HanoiTower {
  public static void main(String[] args) {
    hanoiTowerMove(3,"A","B","C");
  }

  static void hanoiTowerMove(int num,String a,String b,String c){

    if(num == 1){
      log.info("{}번 {} -> {} 이동",num,a,c);
    }else{
      hanoiTowerMove(num - 1 , a,c,b);
      log.info("{}번 {} -> {} 이동",num,a,c);
      hanoiTowerMove(num - 1 , b,a,c);
    }

  }
}
