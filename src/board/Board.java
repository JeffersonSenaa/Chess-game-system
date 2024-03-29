package board;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns){
        //Programação Defensiva
        if(rows < 1 || columns < 1){
            throw new BoardException("Erro ao criar tabuleiro: É necessário conter ao menos 1 linha e 1 coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }
    
    public int getRows() {
        return rows;
    }

    public int getColumns(){
        return columns;
    }

    public Piece piece(int row, int column){
        if(!positionExists(row, column)){
            throw new BoardException("Posição não pertence ao tabuleiro");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Posição não pertence ao tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    //Atribuindo local da peça
    public void placePiece(Piece piece, Position position){
        //Programação Defensiva: Se ja existir uma peça na posição é lançado um erro
        if(thereIsAPiece(position)){
            throw new BoardException("Existe uma peça na posição " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Posição não pertence ao tabuleiro");
        }
        if(piece(position) == null){
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }
    
    

    private boolean positionExists(int row, int column){
        //Maior que zero e menor que a altura e largura do tabuleiro
        return row >= 0 && row < rows && column >=0 && column < columns;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Posição não pertence ao tabuleiro");
        }
        return piece(position) != null;
    }
}
