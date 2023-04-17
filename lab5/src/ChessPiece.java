/*
 * 6. Define an interface called ChessPiece which defines the prototype for the
 * method move(). Create the specific classes for each of the chess pieces and
 * implement the move() method according to the rules of movement on the chess
 * board. The method takes as input the chess piece’s current location and the
 * direction of the move given by the geographical coordinates (N, S, E, V, NE,
 * NV, SE, SV), and returns the final position of the piece. Pay attention to
 * the pieces which can move a different number of cells!!
 */

import java.util.Map;

public interface ChessPiece {
    Map<String, Integer> move(Map<String, Integer> position, String direction, int distance);
}

class Pawn implements ChessPiece {
    @Override
    public Map<String, Integer> move(Map<String, Integer> position, String direction, int distance) {
        int posx = position.get("x");
        int posy = position.get("y");

        if (!direction.matches("^N[WE]?$"))
            throw new RuntimeException();

        for (var i : direction.toCharArray()) {
            switch (i) {
                case 'N' -> {
                    if (posy + distance < 8) posy += distance;
                }
                case 'E' -> {
                    if (posx + distance < 8) posx += distance;
                }
                case 'W' -> {
                    if (posx - distance >= 0) posx -= distance;
                }
                default -> {
                }
            }
        }

        position.replace("x", posx);
        position.replace("y", posy);
        return position;
    }
}

class Royal implements ChessPiece {
    @Override
    public Map<String, Integer> move(Map<String, Integer> position, String direction, int distance) {
        int posx = position.get("x");
        int posy = position.get("y");

        if (!direction.matches("^[NS]?[WE]?$"))
            throw new RuntimeException();

        for (var i : direction.toCharArray()) {
            switch (i) {
                case 'N' -> {
                    if (posy + distance < 8) posy += distance;
                }
                case 'S' -> {
                    if (posy - distance >= 0) posy -= distance;
                }
                case 'E' -> {
                    if (posx + distance < 8) posx += distance;
                }
                case 'W' -> {
                    if (posx - distance >= 0) posx -= distance;
                }
                default -> {
                }
            }
        }

        position.replace("x", posx);
        position.replace("y", posy);
        return position;
    }
}

class Bishop implements ChessPiece {
    @Override
    public Map<String, Integer> move(Map<String, Integer> position, String direction, int distance) {
        int posx = position.get("x");
        int posy = position.get("y");

        if (!direction.matches("^[NS][WE]$"))
            throw new RuntimeException();

        for (var i : direction.toCharArray()) {
            switch (i) {
                case 'N' -> {
                    if (posy + distance < 8) posy += distance;
                }
                case 'S' -> {
                    if (posy - distance >= 0) posy -= distance;
                }
                case 'E' -> {
                    if (posx + distance < 8) posx += distance;
                }
                case 'W' -> {
                    if (posx - distance >= 0) posx -= distance;
                }
                default -> {
                }
            }
        }

        position.replace("x", posx);
        position.replace("y", posy);
        return position;
    }
}

class Rook implements ChessPiece {
    @Override
    public Map<String, Integer> move(Map<String, Integer> position, String direction, int distance) {
        int posx = position.get("x");
        int posy = position.get("y");

        if (!direction.matches("^[NSWE]$"))
            throw new RuntimeException();

        for (var i : direction.toCharArray()) {
            switch (i) {
                case 'N' -> {
                    if (posy + distance < 8) posy += distance;
                }
                case 'S' -> {
                    if (posy - distance >= 0) posy -= distance;
                }
                case 'E' -> {
                    if (posx + distance < 8) posx += distance;
                }
                case 'W' -> {
                    if (posx - distance >= 0) posx -= distance;
                }
                default -> {
                }
            }
        }

        position.replace("x", posx);
        position.replace("y", posy);
        return position;
    }
}

class Knight implements ChessPiece {
    @Override
    public Map<String, Integer> move(Map<String, Integer> position, String direction, int distance) {
        int posx = position.get("x");
        int posy = position.get("y");

        if (!direction.matches("^[NS]?[WE]?$"))
            throw new RuntimeException();

        switch (direction) {
            case "N" -> {
                if (posy - 2 >= 0 && posx + 1 < 8) {
                    posy -= 2;
                    posx += 1;
                }
            }
            case "S" -> {
                if (posy + 2 < 8 && posx - 1 >= 0) {
                    posy += 2;
                    posx -= 1;
                }
            }
            case "E" -> {
                if (posx + 2 < 8 && posy + 1 < 8) {
                    posy += 2;
                    posx += 1;
                }
            }
            case "W" -> {
                if (posx - 2 >= 0 && posy - 1 >= 0) {
                    posy -= 2;
                    posx -= 1;
                }
            }
            case "NE" -> {
                if (posy - 1 >= 0 && posx + 2 < 8) {
                    posy -= 1;
                    posx += 2;
                }
            }
            case "NW" -> {
                if (posy - 2 >= 0 && posx - 1 >= 0) {
                    posy -= 2;
                    posx -= 1;
                }
            }
            case "SE" -> {
                if (posy + 2 < 8 && posx + 1 < 8) {
                    posy += 2;
                    posx += 1;
                }
            }
            case "SW" -> {
                if (posy + 1 < 8 && posx - 2 >= 0) {
                    posy += 1;
                    posx -= 2;
                }
            }
            default -> {
            }
        }

        position.replace("x", posx);
        position.replace("y", posy);
        return position;
    }
}
