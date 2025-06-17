//
//  UserDefaultsManager.swift
//  Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 16/06/25.
//

import Foundation

class UserDefaultsManager {
    private static let userKey = "userKey"
    private static let userName = "userName"
    
    static func saveUser(user: User) -> Void {
        let encoder = JSONEncoder()
        if let encode = try? encoder.encode(user) {
            UserDefaults.standard.set(encode, forKey: userKey)
            UserDefaults.standard.synchronize()
        }
    }
    
    static func saveUserName(name: String) -> Void {
        UserDefaults.standard.set(name, forKey: userName)
        UserDefaults.standard.synchronize()
    }
    
    static func loadUser() -> User? {
        if let userData = UserDefaults.standard.data(forKey: userKey) {
            let decoder = JSONDecoder()
            if let user = try? decoder.decode(User.self, from: userData) {
                return user
            }
        }
        return nil
    }
    
    static func loadUserName() -> String? {
        return UserDefaults.standard.string(forKey: userName)
    }
    
    static func removeUser() -> Void {
        UserDefaults.standard.removeObject(forKey: userKey)
        UserDefaults.standard.synchronize()
    }
    
    static func removeUserName() -> Void {
        UserDefaults.standard.removeObject(forKey: userName)
        UserDefaults.standard.synchronize()
    }
}
