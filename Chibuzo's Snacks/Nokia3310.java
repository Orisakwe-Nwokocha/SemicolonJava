import java.util.Scanner;

public class Nokia3310 {

	public static void main(String[] args) {

	Scanner input = new Scanner(System.in);
	
	String text = "Home";
        int width = 20;
	int totalSpaces = width - text.length();
        int spacesOnLeft = totalSpaces / 2;

	System.out.printf("Welcome!!!%n%n");
	System.out.printf("%" + (spacesOnLeft + text.length()) + "s", text);

	System.out.printf("%n%n1. Phone book%n2. Messages%n3. Chat%n4. Call Register%n5. Tones%n6. Settings%n7. Call Divert%n8. Games%n9. Speed dials%n10. Reminders%n11. Clock%n12. Profiles%n13. SIM services%n%nEnter option: ");

	int menu = input.nextInt();

	switch (menu) {
		case 1:
			System.out.printf("%n1. Search%n2. Service Nos%n3. Add name%n4. Erase%n5. Edit%n6. Assign tone%n7. Send b’card%n8. Options%n9. Speed dials%n10. Voice tags%n%nEnter option: ");
			int phonebookMenu = input.nextInt();

				switch (phonebookMenu) {
					case 1:
						System.out.printf("%nSearch%n");
						break;

					case 2:
						System.out.printf("%nService Nos%n");
						break;

					case 3:
						System.out.printf("%nAdd name%n");
						break;

					case 4:
						System.out.printf("%nErase%n");
						break;

					case 5:
						System.out.printf("%nEdit%n");
						break;

					case 6:
						System.out.printf("%nAssign tone%n");
						break;

					case 7:
						System.out.printf("%nSend b’card%n");
						break;

					case 8:
						System.out.printf("%n1. Type of view%n2. Memory status%n%nEnter option: ");
						int optionsPhonebookMenu = input.nextInt();
						
						if (optionsPhonebookMenu == 1){
							System.out.printf("%nType of view%n");
						}
						if (optionsPhonebookMenu == 2){
							System.out.printf("%nMemory status%n");
						}

						break;

					case 9:
						System.out.printf("%nSpeed dials%n");
						break;

					case 10:
						System.out.printf("%nVoice tags%n");
						break;
				}

			break;

		case 2:
			System.out.printf("%n1. Write messages%n2. Inbox%n3. Outbox%n4. Picture messages%n5. Templates%n6. Smileys%n7. Message settings%n8. Info service%n9. Voice mailbox number%n10. Service command editor%n%nEnter option: ");
			int messagesMenu = input.nextInt();

				switch (messagesMenu) {
					case 1:
						System.out.printf("%nWrite messages%n");
						break;

					case 2:
						System.out.printf("%nInbox%n");
						break;

					case 3:
						System.out.printf("%nOutbox%n");
						break;

					case 4:
						System.out.printf("%nErase%n");
						break;

					case 5:
						System.out.printf("%nPicture messages%n");
						break;

					case 6:
						System.out.printf("%nTemplates%n");
						break;

					case 7:
						System.out.printf("%n1. Set 1%n2. Common%n%nEnter option: ");
						int optionsMessagesMenu = input.nextInt();
						
						if (optionsMessagesMenu == 1){
							System.out.printf("%n1. Message centre number%n2. Messages sent as%n3. Message validity%nEnter option: ");
							int moreOptions = input.nextInt();

							if (moreOptions == 1) {
								System.out.printf("%nMessage centre number%n");
							}

							if (moreOptions == 2) {
								System.out.printf("%nMessages sent as%n");
							}


							if (moreOptions == 3) {
								System.out.printf("%nMessage validity%n");
							}
						}

						if (optionsMessagesMenu == 2){
							System.out.printf("%n1. Delivery reports%n2. Reply via same centre%n3. Character support%n%nEnter option: ");
							int moreOptions2 = input.nextInt();

							if (moreOptions2 == 1) {
								System.out.printf("%nDelivery reports%n");
							}

							if (moreOptions2 == 2) {
								System.out.printf("%nReply via same centre%n");
							}


							if (moreOptions2 == 3) {
								System.out.printf("%nCharacter support%n");
							}
						}
						
						break;

					case 8:
						System.out.printf("%nInfo service%n");
						break;

					case 9:
						System.out.printf("%nVoice mailbox number%n");
						break;

					case 10:
						System.out.printf("%nService command editorn");
						break;
				}
			break;

		case 3:
			System.out.printf("%nChat%n");
			break;

		case 4:
			System.out.printf("%n1. Missed calls%n2. Received calls%n3. Dialled numbers%n4. Erase recent call lists%n5. Show call duration%n6. Show call costs%n7. Call cost settings%n8. Prepaid credit%n%nEnter option: ");
			int callRegisterMenu = input.nextInt();

				switch (callRegisterMenu) {
					case 1:
						System.out.printf("%nMissed calls%n");
						break;

					case 2:
						System.out.printf("%nReceived calls%n");
						break;

					case 3:
						System.out.printf("%nDialled numbers%n");
						break;

					case 4:
						System.out.printf("%nErase recent call lists%n");
						break;

					case 5:
						System.out.printf("%n1. Last call duration%n2. All calls' duration%n3. Received calls' duration%n4. Dialled calls' duration%n5. Clear timers%n%nEnter option: ");
						int showCallDuration = input.nextInt();
						
						
						if (showCallDuration == 1) {
							System.out.printf("%nLast call duration%n");
						}

						if (showCallDuration == 2) {
							System.out.printf("%nAll calls' duration%n");
						}

						if (showCallDuration == 3) {
							System.out.printf("%nReceived calls' duration%n");
						}

						if (showCallDuration == 4) {
							System.out.printf("%nDialled calls' duration%n");
						}

						if (showCallDuration == 5) {
							System.out.printf("%nClear timers%n");
						}
						
						break;

					case 6:
						System.out.printf("%n1. Last call cost%n2. All calls' cost%n3. Clear counters%n%nEnter option: ");
						int showCallCosts = input.nextInt();
						
						
						if (showCallCosts == 1) {
							System.out.printf("%nLast call cost%n");
						}

						if (showCallCosts == 2) {
							System.out.printf("%nAll calls' cost%n");
						}

						if (showCallCosts == 3) {
							System.out.printf("%nClear counters%n");
						}
					
						break;

					case 7:
						System.out.printf("%n1. Call cost limit%n2. Show costs in%n%nEnter option: ");
						int callCostSettings = input.nextInt();
						
						
						if (callCostSettings == 1) {
							System.out.printf("%nCall cost limit%n");
						}

						if (callCostSettings == 2) {
							System.out.printf("%nShow costs in%n");
						}
									
						break;
		
					case 8:
						System.out.printf("%nPrepaid credit%n");
						break;
				}
			break;

		case 5:
			System.out.printf("%n1. Ringing tone%n2. Ringing volume%n3. Incoming call alert%n4. Composer%n5. Message alert tone%n6. Keypad tones%n7. Warning and game tones%n8. Vibrating alert%n9. Screen saver%n%nEnter option: ");
			int tonesMenu = input.nextInt();

				switch (tonesMenu) {
					case 1:
						System.out.printf("%nRinging tone%n");
						break;
					case 2:
						System.out.printf("%Ringing volume%n");
						break;
					case 3:
						System.out.printf("%nIncoming call alert%n");
						break;
					case 4:
						System.out.printf("%nComposer%n");
						break;
					case 5:
						System.out.printf("%nMessage alert tone%n");
						break;
					case 6:
						System.out.printf("%nKeypad tones%n");
						break;
					case 7:
						System.out.printf("%nWarning and game tones%n");
						break;
					case 8:
						System.out.printf("%nVibrating alert%n");
						break;
					case 9:
						System.out.printf("%nScreen saver%n");
						break;
				}
			break;

		case 6:
			System.out.printf("%n1. Call settings%n2. Phone settings%n3. Security settings%n4. Restore factory settings%n%nEnter option: ");
			int settingsMenu = input.nextInt();

				switch (settingsMenu) {
					case 1:
						System.out.printf("%n1. Automatic redial%n2. Speed dialling%n3. Call waiting options%n4. Own number sending%n5. Phone line in use%n6. Automatic answer%n%nEnter option: ");
						int callSettings = input.nextInt();
						
						if (callSettings == 1) {
							System.out.printf("%nAutomatic redial%n");
						}

						if (callSettings == 2) {
							System.out.printf("%nSpeed dialling%n");
						}

						if (callSettings == 3) {
							System.out.printf("%nCall waiting options%n");
						}

						if (callSettings == 4) {
							System.out.printf("%nOwn number sending%n");
						}

						if (callSettings == 5) {
							System.out.printf("%nPhone line in use%n");
						}

						if (callSettings == 6) {
							System.out.printf("%nAutomatic answer%n");
						}

						break;

					case 2:
						System.out.printf("%n1. Language%n2. Cell info display%n3. Welcome note%n4. Network selection%n5. Lights%n6. Confirm SIM service actions%n%nEnter option: ");
						int phoneSettings = input.nextInt();
						
						if (phoneSettings == 1) {
							System.out.printf("%nLanguage%n");
						}

						if (phoneSettings == 2) {
							System.out.printf("%nCell info display%n");
						}

						if (phoneSettings == 3) {
							System.out.printf("%nWelcome note%n");
						}

						if (phoneSettings == 4) {
							System.out.printf("%nNetwork selection%n");
						}

						if (phoneSettings == 5) {
							System.out.printf("%nLights%n");
						}

						if (phoneSettings == 6) {
							System.out.printf("%nConfirm SIM service actions%n");
						}

						break;	
				
					case 3:
						System.out.printf("%n1. PIN code request%n2. Call barring service%n3. Fixed dialling%n4. Closed user group%n5. Phone security%n6. Change access codes%n%nEnter option: ");
						int securitySettings = input.nextInt();
						
						if (securitySettings == 1) {
							System.out.printf("%nPIN code request%n");
						}

						if (securitySettings == 2) {
							System.out.printf("%nCall barring service%n");
						}

						if (securitySettings == 3) {
							System.out.printf("%nFixed dialling%n");
						}

						if (securitySettings == 4) {
							System.out.printf("%nClosed user group%n");
						}

						if (securitySettings == 5) {
							System.out.printf("%nPhone security%n");
						}

						if (securitySettings == 6) {
							System.out.printf("%nChange access codes%n");
						}

						break;

					case 4:
						System.out.printf("%nRestore factory settings%n");
						break;
				}
			break;

		case 7:
			System.out.printf("%nCall divert%n");
			break;

		case 8:
			System.out.printf("%nGames%n");
			break;

		case 9:
			System.out.printf("%nCalculator%n");
			break;

		case 10:
			System.out.printf("%nReminders%n");
			break;

		case 11:
			System.out.printf("%n1. Alarm clock%n2. Clock settings%n3. Date setting%n4. Stopwatch%n5. Countdown timer%n6. Auto update of date and time%n%nEnter option: ");
			int clockMenu = input.nextInt();

				switch (clockMenu) {
					case 1:
						System.out.printf("%nAlarm clock%n");
						break;
					case 2:
						System.out.printf("%Clock settings%n");
						break;
					case 3:
						System.out.printf("%nDate settings%n");
						break;
					case 4:
						System.out.printf("%nStopwatch%n");
						break;
					case 5:
						System.out.printf("%nCountdown timer%n");
						break;
					case 6:
						System.out.printf("%nAuto update of date and time%n");
						break;
				}
			break;

		case 12:
			System.out.printf("%nProfiles%n");
			break;

		case 13:
			System.out.printf("%nSIM services%n");
			break; 
	}


   }

}