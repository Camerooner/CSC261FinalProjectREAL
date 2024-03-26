package com.mycompany.csc261pokedexfinalproject;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import java.util.Random;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author Cam
 */

public class PokemonQuiz extends javax.swing.JPanel {

    private int remainingGuesses = 3;
    private Pokemon currentPokemon;
    private final AudioPlayer audioPlayer = new AudioPlayer();
    
    /**
     * Creates new form PokemonQuiz
     */
    
    public PokemonQuiz() {
        initComponents();
        this.setBackground(new java.awt.Color(217, 76, 56));
        retryQuizButton.setEnabled(false);
        guessEntererTextField.setEnabled(false);
        typeInfoField.setEditable(false);
        generationInfoField.setEditable(false);
        weightInfoField.setEditable(false);
        bstInfoField.setEditable(false);
        finalPokemonLabel.setVisible(false);
    }

    private void startGame() {
        remainingGuesses = 3;
        numberGuessesLabel.setText(String.valueOf(remainingGuesses));
        currentPokemon = fetchRandomPokemon();
        displayInitialPokemonInfo(currentPokemon);
        guessEntererTextField.setEnabled(true);
        retryQuizButton.setEnabled(false);
        playQuizButton.setEnabled(false);
        finalPokemonLabel.setVisible(false);
    }

    private Pokemon fetchRandomPokemon() {
        Random random = new Random();
        int pokemonId = random.nextInt(1025) + 1;
        return PokedexApp.fetchPokemonDetailsById(pokemonId);
    }
    
    private String capitalizeFirstLetter(String input) { // This code is repeated and I wanna try and use the method I already defined in PokedexGUI instead
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    private void displayInitialPokemonInfo(Pokemon pokemon) {
        if (pokemon != null) {
            // Capitalize each type and join with comma
            String capitalizedTypes = pokemon.getTypes().stream()
                    .map(type -> capitalizeFirstLetter(type.getType().getName()))
                    .collect(Collectors.joining(", "));
            typeInfoField.setText(capitalizedTypes);
            generationInfoField.setText("Gen " + calculateGeneration(pokemon.getId()));
            weightInfoField.setText(""); // Clear the text field, so it doesn't show yet
            bstInfoField.setText("");
        }
    }

    private void checkGuess(String guess) {
        // Checks if the users guess is a valid Pokémon name or number within the range
        boolean isValidGuess = isValidPokemon(guess);

        if (isValidGuess) {
            if (guess.equalsIgnoreCase(currentPokemon.getName()) || guess.equals(String.valueOf(currentPokemon.getId()))) {
                revealPokemon();
            } else {
                remainingGuesses--;
                numberGuessesLabel.setText(String.valueOf(remainingGuesses));
                updateInfoFieldsBasedOnGuesses();
            }
        }
    }
    
    private boolean isValidPokemon(String guess) {
        try {
            int dexNumber = Integer.parseInt(guess);
            return dexNumber >= 1 && dexNumber <= 1025;
        } catch (NumberFormatException e) {
            Pokemon pokemon = PokedexApp.fetchPokemonDetailsByName(guess);
            return pokemon != null;
        }
    }

    private void updateInfoFieldsBasedOnGuesses() {
        if (remainingGuesses == 2) {
            weightInfoField.setText(currentPokemon.getWeight() + " lbs"); // Shows weight after first wrong guess
        } else if (remainingGuesses == 1) {
            bstInfoField.setText(String.valueOf(calculateBST(currentPokemon))); // Shows BST after second wrong guess
        }
        if (remainingGuesses == 0) {
            revealPokemon(); // Shows all info if no guesses left
        }
    }

    private void revealPokemon() {
        // Capitalize the first letter of the Pokémon's name
        finalPokemonLabel.setText("The Pokémon was: " + capitalizeFirstLetter(currentPokemon.getName()));
        finalPokemonLabel.setVisible(true);

        // Capitalize each type for the final reveal
        String capitalizedTypes = currentPokemon.getTypes().stream()
                .map(type -> capitalizeFirstLetter(type.getType().getName()))
                .collect(Collectors.joining(", "));
        typeInfoField.setText(capitalizedTypes);

        weightInfoField.setText(currentPokemon.getWeight() + " lbs");
        bstInfoField.setText(String.valueOf(calculateBST(currentPokemon)));

        retryQuizButton.setEnabled(true);
        playQuizButton.setEnabled(false);
        guessEntererTextField.setEnabled(false);
    }

    private int calculateBST(Pokemon pokemon) {
        return pokemon.getStats().stream().mapToInt(stat -> stat.getBaseStat()).sum();
    }

    private String calculateGeneration(int pokemonId) {
        if (pokemonId <= 151) {
            return "1";
        } else if (pokemonId <= 251) {
            return "2";
        } else if (pokemonId <= 386) {
            return "3";
        } else if (pokemonId <= 493) {
            return "4";
        } else if (pokemonId <= 649) {
            return "5";
        } else if (pokemonId <= 721) {
            return "6";
        } else if (pokemonId <= 809) {
            return "7";
        } else if (pokemonId <= 905) {
            return "8";
        } else {
            return "9";
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        howToPlayButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        whosThatPokemonLabel = new javax.swing.JLabel();
        guessEntererLabel = new javax.swing.JLabel();
        guessEntererTextField = new javax.swing.JTextField();
        guessesLeftLabel = new javax.swing.JLabel();
        playQuizButton = new javax.swing.JButton();
        retryQuizButton = new javax.swing.JButton();
        numberGuessesLabel = new javax.swing.JLabel();
        typeGameLabel = new javax.swing.JLabel();
        generationGameLabel = new javax.swing.JLabel();
        weightGameLabel = new javax.swing.JLabel();
        bstGameLabel = new javax.swing.JLabel();
        finalPokemonLabel = new javax.swing.JLabel();
        typeInfoField = new javax.swing.JTextField();
        generationInfoField = new javax.swing.JTextField();
        weightInfoField = new javax.swing.JTextField();
        bstInfoField = new javax.swing.JTextField();

        howToPlayButton.setFont(new java.awt.Font("Pokemon Solid", 0, 12)); // NOI18N
        howToPlayButton.setText("How to Play!");
        howToPlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                howToPlayButtonActionPerformed(evt);
            }
        });

        whosThatPokemonLabel.setFont(new java.awt.Font("Pokemon Solid", 0, 36)); // NOI18N
        whosThatPokemonLabel.setText("Who's that Pokémon? ");

        guessEntererLabel.setFont(new java.awt.Font("Pokemon Solid", 0, 12)); // NOI18N
        guessEntererLabel.setText("Enter your guess:");

        guessEntererTextField.setFont(new java.awt.Font("Pokemon Solid", 0, 12)); // NOI18N
        guessEntererTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessEntererTextFieldActionPerformed(evt);
            }
        });

        guessesLeftLabel.setFont(new java.awt.Font("Pokemon Solid", 0, 12)); // NOI18N
        guessesLeftLabel.setText("Guesses left:");

        playQuizButton.setFont(new java.awt.Font("Pokemon Solid", 0, 12)); // NOI18N
        playQuizButton.setText("Play!");
        playQuizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playQuizButtonActionPerformed(evt);
            }
        });

        retryQuizButton.setFont(new java.awt.Font("Pokemon Solid", 0, 12)); // NOI18N
        retryQuizButton.setText("Retry?");
        retryQuizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retryQuizButtonActionPerformed(evt);
            }
        });

        numberGuessesLabel.setFont(new java.awt.Font("Pokemon Solid", 1, 14)); // NOI18N
        numberGuessesLabel.setText("3");

        typeGameLabel.setFont(new java.awt.Font("Pokemon Solid", 0, 12)); // NOI18N
        typeGameLabel.setText("Type:");

        generationGameLabel.setFont(new java.awt.Font("Pokemon Solid", 0, 12)); // NOI18N
        generationGameLabel.setText("Generation:");

        weightGameLabel.setFont(new java.awt.Font("Pokemon Solid", 0, 12)); // NOI18N
        weightGameLabel.setText("Weight:");

        bstGameLabel.setFont(new java.awt.Font("Pokemon Solid", 0, 12)); // NOI18N
        bstGameLabel.setText("BST:");

        finalPokemonLabel.setFont(new java.awt.Font("Pokemon Solid", 0, 24)); // NOI18N
        finalPokemonLabel.setText("The Pokémon was:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(playQuizButton)
                                .addGap(59, 59, 59)
                                .addComponent(retryQuizButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(guessEntererLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guessEntererTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(guessesLeftLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numberGuessesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bstGameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bstInfoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(weightGameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(weightInfoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(generationGameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(generationInfoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(typeGameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(typeInfoField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(307, 307, 307))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(howToPlayButton)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(finalPokemonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(whosThatPokemonLabel))
                        .addGap(45, 45, 45))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(howToPlayButton)
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(whosThatPokemonLabel)
                .addGap(18, 18, 18)
                .addComponent(finalPokemonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeGameLabel)
                    .addComponent(typeInfoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generationGameLabel)
                    .addComponent(generationInfoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weightGameLabel)
                    .addComponent(weightInfoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bstGameLabel)
                    .addComponent(bstInfoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guessEntererLabel)
                    .addComponent(guessEntererTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guessesLeftLabel)
                    .addComponent(numberGuessesLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playQuizButton)
                    .addComponent(retryQuizButton))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void guessEntererTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessEntererTextFieldActionPerformed
        String guess = guessEntererTextField.getText().trim();
        if (!guess.isEmpty()) {
            checkGuess(guess);
        }
    }//GEN-LAST:event_guessEntererTextFieldActionPerformed

    private void howToPlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_howToPlayButtonActionPerformed
        audioPlayer.playButtonSound("A Button BW.wav");
        JOptionPane.showMessageDialog(this,
                "Welcome to 'Who's that Pokémon?' Quiz!\n\n" +
                "1. Start the game by pressing the 'Play' button.\n" +
                "2. Enter your guess for the Pokémon's name or Pokédex number.\n" +
                "3. You have three attempts to guess correctly.\n" +
                "4. Hints will be revealed after each incorrect guess.\n" +
                "5. Press 'Retry' to play again with a new Pokémon.\n\n" +
                "Can you guess them all? Good luck!"
        );
    }//GEN-LAST:event_howToPlayButtonActionPerformed

    private void playQuizButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playQuizButtonActionPerformed
        audioPlayer.playButtonSound("A Button BW.wav");
        startGame(); // Call to start the game
    }//GEN-LAST:event_playQuizButtonActionPerformed

    private void retryQuizButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retryQuizButtonActionPerformed
        audioPlayer.playButtonSound("A Button BW.wav");
        startGame(); // Restarts the game
        finalPokemonLabel.setVisible(false);
    }//GEN-LAST:event_retryQuizButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bstGameLabel;
    private javax.swing.JTextField bstInfoField;
    private javax.swing.JLabel finalPokemonLabel;
    private javax.swing.JLabel generationGameLabel;
    private javax.swing.JTextField generationInfoField;
    private javax.swing.JLabel guessEntererLabel;
    private javax.swing.JTextField guessEntererTextField;
    private javax.swing.JLabel guessesLeftLabel;
    private javax.swing.JButton howToPlayButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel numberGuessesLabel;
    private javax.swing.JButton playQuizButton;
    private javax.swing.JButton retryQuizButton;
    private javax.swing.JLabel typeGameLabel;
    private javax.swing.JTextField typeInfoField;
    private javax.swing.JLabel weightGameLabel;
    private javax.swing.JTextField weightInfoField;
    private javax.swing.JLabel whosThatPokemonLabel;
    // End of variables declaration//GEN-END:variables
}
