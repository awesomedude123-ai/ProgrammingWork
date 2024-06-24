Describe 'GraphOps'{
    Context 'Resend-GuestUserInvitation'{
        It 'Should resend the guest user invitation'{
            $Path = Join-Path $HOME "guest_user.csv"
            $File = Import-Csv -Path $Path
            Resend-GuestUserInvitation -GuestUserEmail $File.InvitedUserEmailAddress | Should -Not -Be "Error has occurred. Please review and try again"
        }
    }
}