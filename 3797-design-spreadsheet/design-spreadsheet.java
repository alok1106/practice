class Spreadsheet {

    private Map<String, Integer> cells;
    private int rows;

    public Spreadsheet(int rows) {
        this.rows = rows;
        cells = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        if(value == 0) cells.remove(cell);
        cells.put(cell, value);
    }
    
    public void resetCell(String cell) {
        cells.remove(cell);
    }
    
    public int getValue(String formula) {
        formula = formula.substring(1);
        String[] parts = formula.split("\\+");
        int sum = 0;
        for (String part : parts) {
            if (Character.isLetter(part.charAt(0))) {
                // It's a cell reference like A1, B20
                sum += cells.getOrDefault(part, 0);
            } else {
                // It's a number
                sum += Integer.parseInt(part);
            }
        }
        return sum;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */