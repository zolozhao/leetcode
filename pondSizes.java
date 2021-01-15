class Solution {
    private int thisPondSize;

    public int[] pondSizes(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        List<Integer> resultList = new ArrayList<Integer>();

        for (int i=0;i<land.length;i++){
            for (int j=0;j<land[0].length;j++){
                this.thisPondSize = 0;
                this.visitAndFindPond(i,j,visited,land);
                if(this.thisPondSize>0){
                resultList.add(this.thisPondSize);
                }
            }
        }

        int[] result = resultList.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(result);
        return result;

    }

    public void visitAndFindPond(int x, int y, boolean[][] visited, int[][] land){
        if(x<0 || y<0 || x>land.length-1 || y>land[0].length-1){return;}
        if (visited[x][y] == true) {return;}
        visited[x][y] = true;
        if(land[x][y] != 0) {
            return;
        }
        this.thisPondSize++;
        this.visitAndFindPond(x-1,y,visited,land);
        this.visitAndFindPond(x+1,y,visited,land);
        this.visitAndFindPond(x-1,y-1,visited,land);
        this.visitAndFindPond(x+1,y-1,visited,land);
        this.visitAndFindPond(x-1,y+1,visited,land);
        this.visitAndFindPond(x+1,y+1,visited,land);
        this.visitAndFindPond(x,y-1,visited,land);
        this.visitAndFindPond(x,y+1,visited,land);
    }

}
