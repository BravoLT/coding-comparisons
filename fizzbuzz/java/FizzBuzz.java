
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FizzBuzz {
    public static void main(final String[] args) {
        final Integer input = parseArgs(args);

        final String[] forLoopSolutionOutput = forLoopSolution(input);
        System.err.printf(
            "forLoopSolutionOutput (%s)%n%s%n%n",
            forLoopSolutionOutput[0],
            forLoopSolutionOutput[1]
        );

        final String[] streamSolutionOutput = streamSolution(input);
        System.err.printf(
            "streamSolutionOutput (%s)%n%s%n",
            streamSolutionOutput[0],
            streamSolutionOutput[1]
        );
    }

    private static String[] forLoopSolution(final Integer input){
        final long startTime = System.nanoTime();
        final StringBuilder builder = new StringBuilder();
        for(int i = 1; i <= input; i++){
            final boolean isFizz = i % 3 == 0;
            final boolean iSBuzz = i % 5 == 0;

            if(isFizz && iSBuzz){
                builder.append("FizzBuzz");
            }
            else if(isFizz){
                builder.append("Fizz");
            }
            else if(iSBuzz){
                builder.append("Buzz");
            }
            else {
                builder.append(Integer.toString(i));
            }
            builder.append(" ");
        }
        final String output = builder.toString();
        return new String[]{
            String.format("%d microseconds", (System.nanoTime() - startTime) / 1000),
            output.substring(0, output.length() - 1)
        };
    }

    private static String[] streamSolution(final Integer input){
        final long startTime = System.nanoTime();
        final String output = IntStream
                .rangeClosed(1, input)
                .mapToObj(i -> {
                    final boolean isFizz = i % 3 == 0;
                    final boolean iSBuzz = i % 5 == 0;
                    return isFizz ? iSBuzz ? "FizzBuzz" : "Fizz" : iSBuzz ? "Buzz" : Integer.toString(i);
                })
                .collect(Collectors.joining(" "));
        return new String[]{
                String.format("%d microseconds", (System.nanoTime() - startTime) / 1000),
                output
        };
    }

    private static Integer parseArgs(final String[] args){
        if (args.length != 1) {
            throw new IllegalArgumentException("expected 'args.length' to be 1");
        }
        Integer i;
        try {
            i = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("expected 'args[0]' to be a number");
        }
        if(i < 1){
            throw new IllegalArgumentException("expected 'args[0]' to be greater than 0");
        }
        return i;
    }
}