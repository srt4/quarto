package model;

/**
 *
 * @author Spencer Thomas (srt4@uw.edu)
 */
final class PieceToStringHelper {

    static String toString(final QuartoPiece piece) {
        final StringBuilder sb = new StringBuilder();

        switch (piece.getHue()) {
            case LIGHT:
                sb.append(ConsoleColors.ANSI_RED);
                break;
            case DARK:
                sb.append(ConsoleColors.ANSI_YELLOW);
                break;
        }

        char pieceChar = ' ';
        switch (piece.getShape()) {
            case CYLINDER:
                pieceChar = 'o';
                break;
            case CUBE:
                pieceChar = 'c';
                break;
        }

        switch (piece.getHeight()) {
            case TALL:
                sb.append(Character.toUpperCase(pieceChar));
                break;
            case SHORT:
                sb.append(Character.toLowerCase(pieceChar));
                break;
        }

        switch (piece.getFill()) {
            case FILLED:
                sb.append("˙");
                break;
            case HOLLOW:
                sb.append("˚");
                break;
        }

        sb.append(ConsoleColors.ANSI_RESET);

        return sb.toString();
    }

}