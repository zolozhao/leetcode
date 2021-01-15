class Solution {
 private int thisPondSize;

    public int[] pondSizes(int[][] land) {
        int[] result = new int[0];
        if (land.length == 0) {
            return result;
        }
        boolean[][] visited = new boolean[land.length][land[0].length];
        List<Integer> resultList = new ArrayList<Integer>();

        for (int i=0;i<land.length;i++){
            for (int j=0;j<land.length;j++){
                this.thisPondSize = 0;
                this.visitAndFindPond(i,j,visited,land);
                if(this.thisPondSize>0){
                resultList.add(this.thisPondSize);
                }
            }
        }
        resultList.sort(Comparator.<Integer>naturalOrder());
        int[] ret = new int[resultList.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = resultList.get(i).intValue();
        }
        return ret;
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
