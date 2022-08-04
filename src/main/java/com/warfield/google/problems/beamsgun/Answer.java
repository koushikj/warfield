package com.warfield.google.problems.beamsgun;


import java.util.ArrayList;

public class Answer {

    public static void main(String[] args) {
        System.out.println(Answer.answer(new int[]{3, 2}, new int[]{1, 1}, new int[]{2, 1}, 4));
    }
    public static int answer(int[] dimensions, int[] captain_position, int[] badguy_position, int distance) {

        int parallelDimensionX = (2 * (distance / dimensions[0])) + 1;
        int parallelDimensionY = (2 * (distance / dimensions[1])) + 1;
        int numDirections = 0;
        int distanceSquared = (int) Math.pow(distance, 2);
        ArrayList<ArrayList<Double>> directions = new ArrayList<ArrayList<Double>>();
        ArrayList<ArrayList<Double>> sourceDirections = new ArrayList<ArrayList<Double>>();
        ArrayList<ArrayList<int[]>> sourceTracker = new ArrayList<ArrayList<int[]>>();

        for (int i = 0; i < 4; i++) {

            directions.add(new ArrayList<Double>());
            sourceDirections.add(new ArrayList<Double>());
            sourceTracker.add(new ArrayList<int[]>());
        }

        ArrayList<ArrayList<int[]>> mirroredPlanes = MirroredPlanes(badguy_position, dimensions, new int[]{parallelDimensionX, parallelDimensionY});
        ArrayList<ArrayList<int[]>> mirroredSources = MirroredPlanes(captain_position, dimensions, new int[]{parallelDimensionX, parallelDimensionY});

        for (int i = 0; i < parallelDimensionX; i++) {

            for (int j = 0; j < parallelDimensionY; j++) {

                int[] sourcePoint = mirroredSources.get(j).get(i);

                if (sourcePoint[0] == captain_position[0] && sourcePoint[1] == captain_position[1]) {

                    continue;
                }

                int[] vecA = new int[]{sourcePoint[0] - captain_position[0], sourcePoint[1] - captain_position[1]};

                double direction = Math.atan2(vecA[1], vecA[0]);
                int quadrant = 0;
                if (vecA[0] < 0) {

                    quadrant++;
                }
                if (vecA[1] < 0) {

                    quadrant += 2;
                }

                if (!sourceDirections.get(quadrant).contains(direction)) {

                    sourceDirections.get(quadrant).add(direction);
                    sourceTracker.get(quadrant).add(new int[]{j, i});
                } else {

                    int sourceIndex = sourceDirections.get(quadrant).indexOf(direction);

                    if ((sourceTracker.get(quadrant).get(sourceIndex)[0] < j && j < parallelDimensionY / 2) || (sourceTracker.get(quadrant).get(sourceIndex)[0] > j && j > parallelDimensionY / 2)) {

                        sourceTracker.get(quadrant).get(sourceIndex)[0] = j;
                    }

                    if ((sourceTracker.get(quadrant).get(sourceIndex)[1] < i && i < parallelDimensionX / 2) || (sourceTracker.get(quadrant).get(sourceIndex)[1] > i && i > parallelDimensionX / 2)) {

                        sourceTracker.get(quadrant).get(sourceIndex)[1] = i;
                    }
                }
            }
        }

        for (int i = 0; i < parallelDimensionX; i++) {

            for (int j = 0; j < parallelDimensionY; j++) {

                int[] currPoint = mirroredPlanes.get(j).get(i);

                if (captain_position[0] == badguy_position[0] && currPoint[0] == captain_position[0] && currPoint[1] != badguy_position[1]) {

                    continue;
                }

                if (captain_position[1] == badguy_position[1] && currPoint[1] == captain_position[1] && currPoint[0] != badguy_position[0]) {

                    continue;
                }

                if (Math.pow(currPoint[0] - captain_position[0], 2) + Math.pow(currPoint[1] - captain_position[1], 2) <= distanceSquared) {

                    int[] vecA = new int[]{currPoint[0] - captain_position[0], currPoint[1] - captain_position[1]};

                    double direction = Math.atan2(vecA[1], vecA[0]);
                    int quadrant = 0;
                    if (vecA[0] < 0) {

                        quadrant++;
                    }
                    if (vecA[1] < 0) {

                        quadrant += 2;
                    }


                    if (directions.get(quadrant).contains(direction)) {

                        continue;
                    } else {

                        directions.get(quadrant).add(direction);
                    }

                    if (sourceDirections.get(quadrant).contains(direction)) {

                        int index = sourceDirections.get(quadrant).indexOf(direction);

                        int[] sourceIndex = sourceTracker.get(quadrant).get(index);
                        int[] sourcePoint = mirroredSources.get(sourceIndex[0]).get(sourceIndex[1]);

                        if (Math.pow(sourcePoint[0], 2) + Math.pow(sourcePoint[1], 2) < Math.pow(currPoint[0], 2) + Math.pow(currPoint[1], 2)) {

                            continue;
                        }

                    }

                    numDirections++;
                }
            }
        }

        return numDirections;
    }

    public static ArrayList<ArrayList<int[]>> MirroredPlanes(int[] startingLocal, int[] planeDimensions, int[] mirrorDimensions) {

        ArrayList<ArrayList<int[]>> mirroredPlanes = new ArrayList<ArrayList<int[]>>();

        //int[][int[][]] mirroredPlanes = new int[mirrorDimensions[0]][mirrorDimensions[1]];
        int middleX = mirrorDimensions[0] / 2;
        int middleY = mirrorDimensions[1] / 2;

        for (int i = 0; i < mirrorDimensions[1]; i++) {

            ArrayList<int[]> curXList = new ArrayList<int[]>();
            mirroredPlanes.add(curXList);

            for (int j = 0; j < mirrorDimensions[0]; j++) {

                int[] curY = new int[2];

                int[] tempLocal = new int[]{startingLocal[0], startingLocal[1]};

                int modX = j - middleX;
                int modY = i - middleY;

                if (modX % 2 != 0) {

                    tempLocal[0] = planeDimensions[0] - startingLocal[0];
                }
                curY[0] = tempLocal[0] + (modX * planeDimensions[0]);

                if (modY % 2 != 0) {

                    tempLocal[1] = planeDimensions[1] - startingLocal[1];
                }

                curY[1] = tempLocal[1] + (modY * planeDimensions[1]);

                curXList.add(curY);
            }
        }

        return mirroredPlanes;
    }
}