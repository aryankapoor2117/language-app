package lang.view;


import java.io.*;
import java.util.*;
import static lang.Main.*;
import static lang.view.topic.topicMap;

public class LinkedList {
    private Node head;
    private int numNodes;
    public LinkedList(String esp, String eng, int rating) {

        head = new Node(esp, eng, rating);

    }
    public void addAtHead(String esp, String eng, int rating) {

        Node temp = head;

        head = new Node(esp, eng, rating);

        head.next = temp;

        numNodes++;

    }
    public void addAtTail(String esp, String eng, int rating) {

        Node temp = head;

        while (temp.next != null) {

            temp = temp.next;

        }


        temp.next = new Node(esp, eng, rating);

        numNodes++;

    }
    public void deleteAtIndex(int index) {
        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        numNodes--;
    }
    public void deleteHead() {
        Node temp = head.next;
        head = temp;
    }
    public int find(Node n) {

        Node t = head;

        int index = 0;

        while (t != n) {

            index++;

            t = t.next;

        }

        return index;

    }
    public Node find(int index) {

        Node temp = head;

        for (int i = 0; i < index; i++) {

            temp = temp.next;

        }
        // System.out.println(temp.getEsp());
        //System.out.println(temp.getEng());
        //System.out.println(temp.getRating());


        return temp;

    }
    public void printList() {

        Node temp = head;

        while (temp != null) {

            System.out.print(temp.getEsp());
            System.out.print(temp.getEng());
            //System.out.println(temp.getRating());
            temp = temp.next;

        }

    }
    public int getSize() {

        return numNodes;

    }

    public static void writeToFile(String topic, String esp, String eng, int rating) {

        if (topic.equals("Daily Routines")) { /** THIS IF STATEMENT AND FOLLOWING CODE IS REPEATED FOR EVERY TOPIC*/
            try (FileWriter fileWriter = new FileWriter("dailyRoutineFile")) {
                int size = topicMap.get(topic).getSize();
                dailyRoutineString = dailyRoutineString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(dailyRoutineString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Education")) {
            try (FileWriter fileWriter = new FileWriter("educationFile")) {
                int size = topicMap.get(topic).getSize();
                educationString = educationString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(educationString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Food and Drink")) {
            try (FileWriter fileWriter = new FileWriter("foodFile")) {
                int size = topicMap.get(topic).getSize();
                foodString = foodString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(foodString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Personal Details")) {
            try (FileWriter fileWriter = new FileWriter("personalDetailsFile")) {
                int size = topicMap.get(topic).getSize();
                personalDetailsString = personalDetailsString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(personalDetailsString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Appearance and Character")) {
            try (FileWriter fileWriter = new FileWriter("appearanceFile")) {
                int size = topicMap.get(topic).getSize();
                appearanceString = appearanceString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(appearanceString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Health")) {
            try (FileWriter fileWriter = new FileWriter("healthFile")) {
                int size = topicMap.get(topic).getSize();
                healthString = healthString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(healthString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Relationships")) {
            try (FileWriter fileWriter = new FileWriter("relationshipsFile")) {
                int size = topicMap.get(topic).getSize();
                relationshipsString = relationshipsString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(relationshipsString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Shopping")) {
            try (FileWriter fileWriter = new FileWriter("shoppingFile")) {
                int size = topicMap.get(topic).getSize();
                shoppingString = shoppingString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(shoppingString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Employment")) {
            try (FileWriter fileWriter = new FileWriter("employmentFile")) {
                int size = topicMap.get(topic).getSize();
                employmentString = employmentString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(employmentString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Entertainment")) {
            try (FileWriter fileWriter = new FileWriter("entertainmentFile")) {
                int size = topicMap.get(topic).getSize();
                entertainmentString = entertainmentString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(entertainmentString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Holidays")) {
            try (FileWriter fileWriter = new FileWriter("holidaysFile")) {
                int size = topicMap.get(topic).getSize();
                holidaysString = holidaysString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(holidaysString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Media")) {
            try (FileWriter fileWriter = new FileWriter("mediaFile")) {
                int size = topicMap.get(topic).getSize();
                mediaString = mediaString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(mediaString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Sport")) {
            try (FileWriter fileWriter = new FileWriter("sportFile")) {
                int size = topicMap.get(topic).getSize();
                sportString = sportString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(sportString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Technology")) {
            try (FileWriter fileWriter = new FileWriter("technologyFile")) {
                int size = topicMap.get(topic).getSize();
                technologyString = technologyString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(technologyString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Transport")) {
            try (FileWriter fileWriter = new FileWriter("transportFile")) {
                int size = topicMap.get(topic).getSize();
                transportString = transportString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(transportString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Environment")) {
            try (FileWriter fileWriter = new FileWriter("environmentFile")) {
                int size = topicMap.get(topic).getSize();
                environmentString = environmentString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(environmentString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Global Issues")) {
            try (FileWriter fileWriter = new FileWriter("globalIssuesFile")) {
                int size = topicMap.get(topic).getSize();
                globalIssuesString = globalIssuesString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(globalIssuesString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Neighbourhood")) {
            try (FileWriter fileWriter = new FileWriter("neighbourhoodFile")) {
                int size = topicMap.get(topic).getSize();
                neighbourhoodString = neighbourhoodString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(neighbourhoodString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Geography")) {
            try (FileWriter fileWriter = new FileWriter("geographyFile")) {
                int size = topicMap.get(topic).getSize();
                geographyString = geographyString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(geographyString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Towns and Services")) {
            try (FileWriter fileWriter = new FileWriter("townsAndServicesFile")) {
                int size = topicMap.get(topic).getSize();
                townsAndServicesString = townsAndServicesString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(townsAndServicesString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Weather")) {
            try (FileWriter fileWriter = new FileWriter("weatherFile")) {
                int size = topicMap.get(topic).getSize();
                weatherString = weatherString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(weatherString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        } else if (topic.equals("Other")) {
            try (FileWriter fileWriter = new FileWriter("otherFile")) {
                int size = topicMap.get(topic).getSize();
                otherString = otherString + "?" + esp + "." + eng + "!" + rating + "-";
                for (int i = 0; i < size; size++) {
                    fileWriter.write(otherString);
                    fileWriter.close();
                }
            } catch (Exception e) {

            }
        }
    }
    public static String readFromFile(String topic) {
        String s = "";
        if (topic.equals("Daily Routines")) { /** THIS IF STATEMENT AND FOLLOWING CODE IS REPEATED FOR EVERY TOPIC*/
            try (FileInputStream fileInputStream = new FileInputStream("dailyRoutineFile")) {
                int content;
                BufferedReader bf = new BufferedReader(new FileReader("dailyRoutineFile"));
                s=bf.readLine();
            } catch (Exception e) {
            }
        } else if (topic.equals("Education")) {
            try (FileInputStream fileInputStream = new FileInputStream("educationFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("educationFile"));
                s=bf.readLine();

            } catch (Exception e) {
            }
        } else if (topic.equals("Food and Drink")) {
            try (FileInputStream fileInputStream = new FileInputStream("foodFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("foodFile"));
                s=bf.readLine();

            } catch (Exception e) {
            }
        } else if (topic.equals("Personal Details")) {
            try (FileInputStream fileInputStream = new FileInputStream("personalDetailsFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("personalDetailsFile"));
                s=bf.readLine();

            } catch (Exception e) {
            }
        } else if (topic.equals("Appearance and Character")) {
            try (FileInputStream fileInputStream = new FileInputStream("appearanceFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("appearanceFile"));
                s=bf.readLine();

            } catch (Exception e) {
            }
        } else if (topic.equals("Health")) {
            try (FileInputStream fileInputStream = new FileInputStream("healthFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("healthFile"));
                s=bf.readLine();
               /* while ((content = fileInputStream.read()) != -1) {
                    s = s + ((char) content);
                }*/
            } catch (Exception e) {
            }
        } else if (topic.equals("Relationships")) {
            try (FileInputStream fileInputStream = new FileInputStream("relationshipsFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("relationshipsFile"));
                s=bf.readLine();
               /* while ((content = fileInputStream.read()) != -1) {
                    s = s + ((char) content);
                }*/
            } catch (Exception e) {
            }
        } else if (topic.equals("Shopping")) {
            try (FileInputStream fileInputStream = new FileInputStream("shoppingFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("shoppingFile"));
                s=bf.readLine();
               /* while ((content = fileInputStream.read()) != -1) {
                    s = s + ((char) content);
                }*/
            } catch (Exception e) {
            }
        } else if (topic.equals("Employment")) {
            try (FileInputStream fileInputStream = new FileInputStream("employmentFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("employmentFile"));
                s=bf.readLine();
               /* while ((content = fileInputStream.read()) != -1) {
                    s = s + ((char) content);
                }*/
            } catch (Exception e) {
            }
        } else if (topic.equals("Entertainment")) {
            try (FileInputStream fileInputStream = new FileInputStream("entertainmentFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("entertainmentFile"));
                s=bf.readLine();
               /* while ((content = fileInputStream.read()) != -1) {
                    s = s + ((char) content);
                }*/
            } catch (Exception e) {
            }
        } else if (topic.equals("Holidays")) {
            try (FileInputStream fileInputStream = new FileInputStream("holidaysFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("holidaysFile"));
                s=bf.readLine();
               /* while ((content = fileInputStream.read()) != -1) {
                    s = s + ((char) content);
                }*/
            } catch (Exception e) {
            }
        } else if (topic.equals("Media")) {
            try (FileInputStream fileInputStream = new FileInputStream("mediaFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("mediaFile"));
                s=bf.readLine();
               /* while ((content = fileInputStream.read()) != -1) {
                    s = s + ((char) content);
                }*/
            } catch (Exception e) {
            }
        } else if (topic.equals("Sport")) {
            try (FileInputStream fileInputStream = new FileInputStream("sportFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("sportFile"));
                s=bf.readLine();
               /* while ((content = fileInputStream.read()) != -1) {
                    s = s + ((char) content);
                }*/
            } catch (Exception e) {
            }
        } else if (topic.equals("Technology")) {
            try (FileInputStream fileInputStream = new FileInputStream("technologyFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("technologyFile"));
                s=bf.readLine();
               /* while ((content = fileInputStream.read()) != -1) {
                    s = s + ((char) content);
                }*/
            } catch (Exception e) {
            }
        } else if (topic.equals("Transport")) {
            try (FileInputStream fileInputStream = new FileInputStream("transportFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("transportFile"));
                s=bf.readLine();
               /* while ((content = fileInputStream.read()) != -1) {
                    s = s + ((char) content);
                }*/
            } catch (Exception e) {
            }
        } else if (topic.equals("Environment")) {
            try (FileInputStream fileInputStream = new FileInputStream("environmentFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("environmentFile"));
                s=bf.readLine();
               /* while ((content = fileInputStream.read()) != -1) {
                    s = s + ((char) content);
                }*/
            } catch (Exception e) {
            }
        } else if (topic.equals("Global Issues")) {
            try (FileInputStream fileInputStream = new FileInputStream("globalIssuesFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("globalIssuesFile"));
                s=bf.readLine();
               /* while ((content = fileInputStream.read()) != -1) {
                    s = s + ((char) content);
                }*/
            } catch (Exception e) {
            }
        } else if (topic.equals("Neighbourhood")) {
            try (FileInputStream fileInputStream = new FileInputStream("neighbourhoodFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("neighbourhoodFile"));
                s=bf.readLine();
               /* while ((content = fileInputStream.read()) != -1) {
                    s = s + ((char) content);
                }*/
            } catch (Exception e) {
            }
        } else if (topic.equals("Geography")) {
            try (FileInputStream fileInputStream = new FileInputStream("geographyFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("geographyFile"));
                s=bf.readLine();
               /* while ((content = fileInputStream.read()) != -1) {
                    s = s + ((char) content);
                }*/
            } catch (Exception e) {
            }
        } else if (topic.equals("Towns and Services")) {
            try (FileInputStream fileInputStream = new FileInputStream("townsAndServicesFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("townsAndServicesFile"));
                s=bf.readLine();
               /* while ((content = fileInputStream.read()) != -1) {
                    s = s + ((char) content);
                }*/
            } catch (Exception e) {
            }
        } else if (topic.equals("Weather")) {
            try (FileInputStream fileInputStream = new FileInputStream("weatherFile")) {

                BufferedReader bf = new BufferedReader(new FileReader("weatherFile"));
                s=bf.readLine();
               /* while ((content = fileInputStream.read()) != -1) {
                    s = s + ((char) content);
                }*/
            } catch (Exception e) {
            }
        } else if (topic.equals("Other")) {
            try (FileInputStream fileInputStream = new FileInputStream("otherFile")) {
                BufferedReader bf = new BufferedReader(new FileReader("otherFile"));
                s=bf.readLine();
               /* while ((content = fileInputStream.read()) != -1) {
                    s = s + ((char) content);
                }*/
                int content;

            } catch (Exception e) {
            }
        }


        return s;
    }
    public static void deleteFromFile(String esp, String topic)
    {
        String dataString = "";
        String dataString1 = "";
        int beginNewEntry = 0;//to store first value of each entry
        int endNewEntry = 0;// to store last value of each entry for substring
        String tempEsp = "";
        int begin = 0;
        int end = 0;
        String toReplace = "";// to store substring
        if (topic.equals("Daily Routines")) {
            dataString = readFromFile("Daily Routines");
            try (FileWriter fileWriter = new FileWriter("dailyRoutineFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        dataString1 = dataString.replace(toReplace, "");
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Education")) {
            dataString = readFromFile("Education");
            try (FileWriter fileWriter = new FileWriter("educationFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Food")) {
            dataString = readFromFile("Food");
            try (FileWriter fileWriter = new FileWriter("foodFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Personal Details")) {
            dataString = readFromFile("Personal Details");
            try (FileWriter fileWriter = new FileWriter("personalDetailsFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Appearance and Character")) {
            dataString = readFromFile("Appearance and Character");
            try (FileWriter fileWriter = new FileWriter("appearanceFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Health")) {
            dataString = readFromFile("Health");
            try (FileWriter fileWriter = new FileWriter("healthFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Relationships")) {
            dataString = readFromFile("Relationships");
            try (FileWriter fileWriter = new FileWriter("relationshipsFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Shopping")) {
            dataString = readFromFile("Shopping");
            try (FileWriter fileWriter = new FileWriter("shoppingFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Employment")) {
            dataString = readFromFile("Employment");
            try (FileWriter fileWriter = new FileWriter("employmentFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Entertainment")) {
            dataString = readFromFile("Entertainment");
            try (FileWriter fileWriter = new FileWriter("entertainmentFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Holidays")) {
            dataString = readFromFile("Holidays");
            try (FileWriter fileWriter = new FileWriter("holidaysFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Media")) {
            dataString = readFromFile("Media");
            try (FileWriter fileWriter = new FileWriter("mediaFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Sport")) {
            dataString = readFromFile("Sport");
            try (FileWriter fileWriter = new FileWriter("sportFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Technology")) {
            dataString = readFromFile("Technology");
            try (FileWriter fileWriter = new FileWriter("technologyFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Environment")) {
            dataString = readFromFile("Environment");
            try (FileWriter fileWriter = new FileWriter("environmentFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Global Issues")) {
            dataString = readFromFile("Global Issues");
            try (FileWriter fileWriter = new FileWriter("globalIssuesFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Neighbourhood")) {
            dataString = readFromFile("Neighbourhood");
            try (FileWriter fileWriter = new FileWriter("neighbourhoodFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Geography")) {
            dataString = readFromFile("Geography");
            try (FileWriter fileWriter = new FileWriter("geographyFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Towns and Services")) {
            dataString = readFromFile("Towns and Services");
            try (FileWriter fileWriter = new FileWriter("townsAndServicesFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Weather")) {
            dataString = readFromFile("Weather");
            try (FileWriter fileWriter = new FileWriter("weatherFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Other")) {
            dataString = readFromFile("Other");
            try (FileWriter fileWriter = new FileWriter("otherFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('?', i);
                    beginNewEntry = begin;
                    end = dataString.indexOf('.', i);
                    tempEsp = dataString.substring(begin + 1, end);
                    begin = dataString.indexOf('.', i);
                    end = dataString.indexOf('!', i);
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    endNewEntry = end + 1;
                    i = end;
                    if (tempEsp.equals(esp)) {
                        toReplace = dataString.substring(beginNewEntry, endNewEntry);
                        System.out.println(toReplace);
                        dataString1 = dataString.replace(toReplace, "");
                        System.out.println(dataString);
                        System.out.println(dataString1);
                    }
                }
                fileWriter.flush();
                fileWriter.write(dataString1);
                fileWriter.close();
            } catch (Exception e) {

            }
        }
    }

    public static void updateRatings(String topic) {
        String dataString = "";
        String dataString1 = "";
        int beginNewEntry = 0;
        int endNewEntry = 0;
        String tempEsp = "";
        int begin = 0;
        int end = 0;
        LinkedList list;
        int size = 0;
        int cnt = 0;
        String rating = "";
        String toReplace = "";
        if (topic.equals("Daily Routines")) {/** THIS IF STATEMENT AND ALL FOLLOWING CODE IS REPEATED FOR EACH TOPIC*/
            dataString = readFromFile("Daily Routines");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("dailyRoutineFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Education")) {/** now repeat for each topic**/
            dataString = readFromFile("Education");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("educationFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Education")) {
            dataString = readFromFile("Education");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("educationFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Food")) {
            dataString = readFromFile("Food");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("foodFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Personal Details")) {
            dataString = readFromFile("Personal Details");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("personalDetailsFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Appearance and Character")) {
            dataString = readFromFile("Appearance and Character");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("appearanceFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Health")) {
            dataString = readFromFile("Health");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("healthFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Relationships")) {
            dataString = readFromFile("Relationships");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("relationshipsFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Shopping")) {
            dataString = readFromFile("Shopping");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("shoppingFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Employment")) {
            dataString = readFromFile("Employment");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("employmentFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Entertainment")) {
            dataString = readFromFile("Entertainment");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("entertainmentFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Holidays")) {
            dataString = readFromFile("Holidays");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("holidaysFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Media")) {
            dataString = readFromFile("Media");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("mediaFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Sport")) {
            dataString = readFromFile("Sport");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("sportFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Technology")) {
            dataString = readFromFile("Technology");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("technologyFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Environment")) {
            dataString = readFromFile("Environment");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("environmentFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Global Issues")) {
            dataString = readFromFile("Global Issues");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("globalIssuesFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Neighbourhood")) {
            dataString = readFromFile("Neighbourhood");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("neighbourhoodFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Geography")) {
            dataString = readFromFile("Geography");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("geographyFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Towns and Services")) {
            dataString = readFromFile("Towns and Services");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("townsAndServicesFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Weather")) {
            dataString = readFromFile("Weather");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("weatherFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        } else if (topic.equals("Other")) {
            dataString = readFromFile("Other");
            list = topicMap.get(topic);
            size = list.getSize() + 1;
            cnt = 0;
            try (FileWriter fileWriter = new FileWriter("otherFile")) {
                for (int i = 0; i < dataString.length(); i++) {
                    begin = dataString.indexOf('!', i);
                    end = dataString.indexOf('-', i);
                    toReplace = dataString.substring(begin + 1, end);
                    if (cnt < size) {
                        rating = list.find(cnt).getRating() + "";
                        dataString = dataString.replace(toReplace, rating);
                        i = end;
                    }
                    cnt++;

                }
                fileWriter.flush();
                fileWriter.write(dataString);
                fileWriter.close();
            } catch (Exception e) {

            }
        }
    }
    public static String[] wordsOfTheDay()
    {
        HashMap<String, LinkedList> temp = new HashMap();
        String maxEsp[]= new String[22];
        String maxEng[] = new String[22];
        String max[] = new String[44];
        int maxRating=0;
        int totalcnt=0;
        temp=topicMap;
        Iterator it = temp.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry pair = (Map.Entry) it.next();
            it.remove();
            LinkedList list= (LinkedList) pair.getValue();
            int size = list.getSize();
            for(int i =0;i<size+1;i++)
            {
                if(list.find(i).getRating()>maxRating)
                {
                    maxEsp[totalcnt]=list.find(i).getEsp();
                    maxEng[totalcnt] = list.find(i).getEng();
                    max[totalcnt]=list.find(i).getEsp();
                    max[totalcnt]=list.find(i).getEng();
                }
            }
            totalcnt++;
        }
        int maxcnt=0;
        int espCnt=0;
        int engCnt=0;
        while(maxcnt<44)
        {
            max[maxcnt]=maxEsp[espCnt];
            maxcnt++;
            espCnt++;
            max[maxcnt]=maxEng[engCnt];
            maxcnt++;
            engCnt++;
        }
        return max;
    }

    class Node
    {
        private Node next;
        private Object data;
String esp="";
String eng="";
int rating =1;
        public Node(String esp, String eng, int rating )
        {
            this.esp=esp;
            this.eng=eng;
            this.rating=rating;
        }
        public String getEsp()
        {

            return esp;

        }
        public String getEng()
        {
            return eng;
        }
        public int getRating()
{
    return rating;
}
        public void setRating(int n) {
            rating = n;
        }
    }
}

