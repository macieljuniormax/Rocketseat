//
//  LoginBottomSheetViewModel.swift
//  02 - Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 16/06/25.
//

import Foundation
import Firebase

class LoginBottomSheetViewModel {
    func doAuthentication(username: String, password: String) {
        print(username, password)
        Firebase.Auth.auth().signIn(withEmail: username, password: password) { [weak self] authResult, error in
            if let error = error {
                print("Autenticação não foi realizada com sucesso \(error)")
                
            } else {
                print(authResult ?? "")
            }
        }
    }
}
