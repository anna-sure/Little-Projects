public class Maze {
    public static void main(String[] args) {

        int map[][] = new int[8][7]; // 8 rows 7 cols map

        for (int i = 0; i < 7; i++) { // means cols
            map[0][i] = 1;
            map[7][i] = 1;   // row 1 and row 8 = 1 set walls can't walk
        }

        for (int i = 0; i < 8; i++) {  //means rows
            map[i][0] = 1;
            map[i][6] = 1;  // col 1 and col 7 set walls
        }

        map[3][1] = 1;
        map[3][2] = 1;

        // print the map
        System.out.println("---------- Maze map ----------");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //Test
        T2 t2 = new T2();
        t2.findWay(map, 1, 1);

        System.out.println("---------- Maze map result----------");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
}

class T2 {

    //1. findWay 方法就是专门来找出迷宫的路径
    //2. 如果找到，就返回 true ,否则返回 false
    //3. map 就是二维数组，即表示迷宫
    //4. i,j 就是老鼠的位置，初始化的位置为(1,1)
    //5. 因为我们是递归的找路，所以我先规定 map 数组的各个值的含义
    // 0 表示可以走 1 表示障碍物 2 表示可以走 3 表示走过，但是走不通是死路
    //6. 当 map[6][5] =2 就说明找到通路,就可以结束，否则就继续找.
    // 7. 先确定老鼠找路策略 下->右->上->左

    public boolean findWay(int map[][], int i, int j) {
        if (map[6][5] == 2) {  // find it
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;  // resume 2 can walk;
                // bottom->right->top->left
                if (findWay(map, i + 1, j)) {
                    return true;
                } else if (findWay(map, i, j + 1)) {
                    return true;
                } else if (findWay(map, i - 1, j)) {
                    return true;
                } else if (findWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else { //map[i][j] == 1,2,3
                return false;
            }
        }
    }
}
